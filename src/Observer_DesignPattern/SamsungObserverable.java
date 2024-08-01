package Observer_DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class SamsungObserverable implements IObserverable {

    public List<IObserver> observerList = new ArrayList<>();
    public int stocks = 0;

    @Override
    public void add_observer(IObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove_observer(IObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notify_observer() {
        for(IObserver observer: observerList) {
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
