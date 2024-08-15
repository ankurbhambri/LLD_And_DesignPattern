package Decorator_DesignPattern;

public class NotifyDecorator implements INotify{

    private INotify notify;

    public NotifyDecorator(INotify notify) {
        this.notify = notify;
    }

    @Override
    public String send(String msg) {
        return this.notify.send(msg);
    }
}
