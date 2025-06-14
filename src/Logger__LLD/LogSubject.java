package Logger__LLD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogSubject {
    Map<Integer, List<LogObserver>> logObserverMap = new HashMap<>();

    void addObserver(int level, LogObserver logObserver) {
        List<LogObserver> logObserverList = logObserverMap.getOrDefault(level, new ArrayList<>());
        logObserverList.add(logObserver);
        logObserverMap.put(level, logObserverList);
    }

    void notifyObservers(int level, String msg) {
        for (Map.Entry<Integer, List<LogObserver>> entry : logObserverMap.entrySet()) {
            if(entry.getKey() == level) {
                entry.getValue().forEach(logObserver -> logObserver.log(msg));
            }
        }
    }
}
