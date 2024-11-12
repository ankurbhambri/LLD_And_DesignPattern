package Logger__LLD;

public abstract class AbstractLogger {
    int level;
    AbstractLogger nextLogger;

    public void setNextLoggingLevel(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }
    void logMessage(int level, String msg, LogSubject logSubject) {
        if (this.level == level) {
            display(msg, logSubject);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, msg, logSubject);
        }
    }
    protected abstract void display(String msg, LogSubject logSubject);
}
