package Decorator_DesignPattern;

public class WhatsAppDecorator extends NotifyDecorator{

    private INotify notify;
    public WhatsAppDecorator(INotify notify) {
        super(notify);
    }

    @Override
    public String send(String msg){
        super.send(msg);
        return msg;
    }
}
