package Decorator_DesignPattern;

public class BasicNotify implements INotify{

    @Override
    public String send(String msg) {
        return "Basic notification " + msg;
    }
}
