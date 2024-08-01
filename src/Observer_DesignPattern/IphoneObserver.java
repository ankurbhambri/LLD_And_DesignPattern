package Observer_DesignPattern;

public class IphoneObserver implements IObserver{
    public IphoneObserverable iphoneObserverable;

    public IphoneObserver(IphoneObserverable iphoneObserverable) {
        this.iphoneObserverable = iphoneObserverable;
    }

    @Override
    public void update() {
        sendMessage(String.valueOf(iphoneObserverable.getStocks()));
    }

    public void sendMessage(String msg) {
        System.out.println("Hello Guys your Iphone device is out of stock left: " + msg);
    }
}
