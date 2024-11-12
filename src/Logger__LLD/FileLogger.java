package Logger__LLD;

public class FileLogger implements LogObserver {
    @Override
    public void log(String msg) {
        System.out.println("FILE: " + msg);
    }
}
