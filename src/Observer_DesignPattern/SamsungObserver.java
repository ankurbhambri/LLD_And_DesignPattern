package Observer_DesignPattern;

public class SamsungObserver implements IObserver{
    public SamsungObserverable samsungObserverable;

    public SamsungObserver(SamsungObserverable samsungObserverable) {
        this.samsungObserverable = samsungObserverable;
    }

    @Override
    public void update() {
        sendMessage(String.valueOf(samsungObserverable.getStocks()));
    }

    public void sendMessage(String msg) {
        System.out.println("Hello Guys your Samsung device is out of stock left: " + msg);
    }
}
