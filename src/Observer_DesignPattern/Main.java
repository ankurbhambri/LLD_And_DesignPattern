package Observer_DesignPattern;

public class Main {
    public static void main(String[] args) {

        IphoneObserverable iphoneObserverable = new IphoneObserverable();
        SamsungObserverable samsungObserverable = new SamsungObserverable();

        IphoneObserver iphoneObserver = new IphoneObserver(iphoneObserverable);

        SamsungObserver samsungObserver = new SamsungObserver(samsungObserverable);

        iphoneObserverable.add_observer(iphoneObserver);
        samsungObserverable.add_observer(samsungObserver);

        iphoneObserverable.setStocks(0);
        samsungObserverable.setStocks(0);

    }
}
