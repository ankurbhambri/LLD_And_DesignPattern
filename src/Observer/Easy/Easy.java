package Observer.Easy;

import java.util.List;
import java.util.ArrayList;

interface observer {
    void update(); // this could be anything, idea here is a trigger method for the observers
}

interface observable {
    void add_observer(observer o);
    void remove_observer(observer o);
    void notify_observers(); // this will be called when the observable's state changes, like add, remove, or update
}

class IphoneObserverable implements observable {

    private int stocks;
    private List<observer> observers = new ArrayList<>();

    public void setStocks(int stocks) {
        this.stocks = stocks;
        notify_observers();
    }

    public int getStocks() {
        return stocks;
    }

    @Override
    public void add_observer(observer o) {
        observers.add(o);
    }

    @Override
    public void remove_observer(observer o) {
        observers.remove(o);
    }

    @Override
    public void notify_observers() {
        for (observer o : observers) {
            o.update();
        }
    }
}

class samsungObserverable implements observable {

    private int stocks;
    private List<observer> observers = new ArrayList<>();

    public void setStocks(int stocks) {
        this.stocks = stocks;
        notify_observers();
    }

    public int getStocks() {
        return stocks;
    }

    @Override
    public void add_observer(observer o) {
        observers.add(o);
    }

    @Override
    public void remove_observer(observer o) {
        observers.remove(o);
    }

    @Override
    public void notify_observers() {
        for (observer o : observers) {
            o.update();
        }
    }
    
}

class IphoneObserver implements observer {
    private IphoneObserverable iphoneObserverable;

    public IphoneObserver(IphoneObserverable iphoneObserverable) {
        this.iphoneObserverable = iphoneObserverable;
    }

    @Override
    public void update() {
        System.out.println("Hurray !! Iphone stocks updated: " + iphoneObserverable.getStocks());
    }
}

class SamsungObserver implements observer {
    private samsungObserverable samsungObserverable;

    public SamsungObserver(samsungObserverable samsungObserverable) {
        this.samsungObserverable = samsungObserverable;
    }

    @Override
    public void update() {
        System.out.println("Hurray !! Samsung stocks updated: " + samsungObserverable.getStocks());
    }
}

public class Easy {
    public static void main(String[] args) {

        IphoneObserverable iphoneObserverable = new IphoneObserverable();
        samsungObserverable samsungObserverable = new samsungObserverable();

        IphoneObserver iphoneObserver = new IphoneObserver(iphoneObserverable);
        SamsungObserver samsungObserver = new SamsungObserver(samsungObserverable);

        iphoneObserverable.add_observer(iphoneObserver);
        samsungObserverable.add_observer(samsungObserver);

        iphoneObserverable.setStocks(10);
        samsungObserverable.setStocks(20);
    }
}