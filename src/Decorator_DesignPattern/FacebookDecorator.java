package Decorator_DesignPattern;

public class FacebookDecorator extends NotifyDecorator {

    private INotify notify;
    public FacebookDecorator(INotify notify) {
        super(notify);
    }

    @Override
    public String send(String msg){
        super.send(msg);
        return msg;
    }
}
