package Observer_DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class IphoneObserverable implements IObserverable {

    public List<IObserver> observers = new ArrayList<>();
    public int stocks = 0;

    @Override
    public void add_observer(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove_observer(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notify_observer() {
        for(IObserver observer: observers) {
            observer.update();
        }
    }

    public void setStocks(int newStocks) {
        if(stocks == 0) {
            notify_observer();
        }
        stocks += newStocks;
    }

    public int getStocks() {
        return stocks;
    }
}
