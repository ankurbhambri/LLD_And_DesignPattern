package Logger__LLD;

public class DatabaseLogger implements LogObserver {
    @Override
    public void log(String msg) {
        System.out.println("DATABASE: " + msg);
    }
}
