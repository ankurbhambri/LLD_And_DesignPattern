package Observer.Medium;

import java.util.*;

/*
    A media company wants to design a new News Agency Notification System to improve how they deliver breaking news to their diverse subscriber base.

    The requirements are as follows:

        The system should be capable of notifying different types of users when a news article is published.

        Subscribers should be able to express interest in specific news categories such as "sports", "tech", "politics", etc. Only the relevant subscribers should receive updates in those categories.

        The system should support multiple types of subscribers, each having unique behavior:

        One type prefers receiving messages via email and is only interested in specific categories.

        Another uses a mobile app and wants to be notified for all their chosen categories, and also likes to keep track of how many notifications they’ve received.

        A premium subscriber wants full access to the history of news articles for the topics they’re interested in. However, for some reason, they don’t want to be notified forever — they’d like to automatically stop getting updates after a few notifications.

        The company also wants to maintain a history of news per category, which might be useful for advanced users.

        Subscribers should be allowed to unsubscribe from notifications at any point.

        Ensure that publishing news and notifying subscribers does not result in runtime issues or data consistency problems, especially if notifications are being sent while subscriber lists are being modified.
*/


interface Observer {

    void update(String message, Map<String, Object> meta);
}

interface Subject {

    void registerObserver(Observer observer, Set<String> topics);

    void removeObserver(Observer observer);

    void notifyObservers(String message, String topic, Map<String, Object> meta);
}

// Concrete Subject with topic-based subscriptions and history
class NewsAgency implements Subject {

    private final Map<String, Set<Observer>> topicObservers = new HashMap<>();
    private final Map<Observer, Set<String>> observerTopics = new HashMap<>();
    private final Map<String, List<String>> newsHistory = new HashMap<>();

    @Override
    public void registerObserver(Observer observer, Set<String> topics) {
        observerTopics.put(observer, topics);
        for (String topic : topics) {
            topicObservers.computeIfAbsent(topic, k -> new HashSet<>()).add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        Set<String> topics = observerTopics.remove(observer);
        if (topics != null) {
            for (String topic : topics) {
                Set<Observer> observers = topicObservers.getOrDefault(topic, Collections.emptySet());
                observers.remove(observer);
            }
        }
    }

    @Override
    public void notifyObservers(String message, String topic, Map<String, Object> meta) {
        Set<Observer> observers = topicObservers.getOrDefault(topic, Collections.emptySet());
        for (Observer observer : new HashSet<>(observers)) { // Defensive copy to avoid concurrent modification
            observer.update(message, meta);
        }
    }

    public void publishNews(String topic, String news) {
        newsHistory.computeIfAbsent(topic, k -> new ArrayList<>()).add(news);

        Map<String, Object> meta = new HashMap<>();
        meta.put("timestamp", new Date());
        meta.put("topic", topic);
        meta.put("history", Collections.unmodifiableList(new ArrayList<>(newsHistory.get(topic)))); // Safe history

        notifyObservers(news, topic, meta);
    }

    public List<String> getNewsHistory(String topic) {
        return Collections.unmodifiableList(newsHistory.getOrDefault(topic, Collections.emptyList()));
    }
}

// Concrete Observer 1: EmailSubscriber with topic filter
class EmailSubscriber implements Observer {
    private final String email;
    private final Set<String> interestedTopics;

    public EmailSubscriber(String email, Set<String> topics) {
        this.email = email;
        this.interestedTopics = topics;
    }

    @Override
    public void update(String message, Map<String, Object> meta) {
        String topic = (String) meta.get("topic");
        if (interestedTopics.contains(topic)) {
            System.out.println("Email to " + email + " [" + topic + "]: " + message);
        }
    }
}

// Concrete Observer 2: MobileAppSubscriber with notification count
class MobileAppSubscriber implements Observer {
    private final String username;
    private int notificationCount = 0;

    public MobileAppSubscriber(String username) {
        this.username = username;
    }

    @Override
    public void update(String message, Map<String, Object> meta) {
        notificationCount++;
        String topic = (String) meta.get("topic");
        System.out.println("Push to " + username + " [" + topic + "] (" + notificationCount + "): " + message);
    }
}

// Concrete Observer 3: PremiumSubscriber with auto-unsubscribe and history access
class PremiumSubscriber implements Observer {
    private final String name;
    private final Subject subject;
    private final Set<String> topics;
    private int messageCount = 0;

    public PremiumSubscriber(String name, Subject subject, Set<String> topics) {
        this.name = name;
        this.subject = subject;
        this.topics = topics;
    }

    @Override
    public void update(String message, Map<String, Object> meta) {
        messageCount++;
        String topic = (String) meta.get("topic");
        Object historyObj = meta.get("history");
        List<String> history = historyObj instanceof List
                ? (List<String>) historyObj
                : Collections.emptyList();

        System.out.println("Premium " + name + " [" + topic + "] received: " + message);
        System.out.println("History for topic '" + topic + "': " + history);

        // Automatically unsubscribe after receiving 3 messages
        if (messageCount >= 3) {
            System.out.println("Premium " + name + " unsubscribing after 3 messages.");
            subject.removeObserver(this);
        }
    }
}

// Demo runner
public class Medium {

    public static void main(String[] args) {

        NewsAgency agency = new NewsAgency();

        Observer email1 = new EmailSubscriber("user1@example.com", Set.of("sports", "tech"));
        Observer email2 = new EmailSubscriber("user2@example.com", Set.of("politics"));
        Observer app1 = new MobileAppSubscriber("user3");
        Observer premium = new PremiumSubscriber("VIP", agency, Set.of("tech", "politics"));

        agency.registerObserver(email1, Set.of("sports", "tech"));
        agency.registerObserver(email2, Set.of("politics"));
        agency.registerObserver(app1, Set.of("sports", "tech", "politics"));
        agency.registerObserver(premium, Set.of("tech", "politics"));

        agency.publishNews("tech", "Breaking: New Java Version Released!");
        agency.publishNews("sports", "Sports Update: Local Team Wins!");
        agency.publishNews("politics", "Election Results Announced!");
        agency.publishNews("tech", "Tech: Observer Pattern Advanced Example!");
        agency.publishNews("politics", "Politics: New Policy Introduced!");
    }
}
