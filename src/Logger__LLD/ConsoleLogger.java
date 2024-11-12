package Logger__LLD;

public class ConsoleLogger implements LogObserver {
    @Override
    public void log(String msg) {
        System.out.println("CONSOLE: " + msg);
    }
}
