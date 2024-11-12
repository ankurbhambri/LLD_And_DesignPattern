package Logger__LLD;

public class LogManager {
    protected static AbstractLogger buildChainOfLoggers() {
        AbstractLogger infoLogger = new InfoLogger(1);
        AbstractLogger errorLogger = new ErrorLogger(2);
        AbstractLogger debugLogger = new DebugLogger(3);

        infoLogger.setNextLoggingLevel(errorLogger);
        errorLogger.setNextLoggingLevel(debugLogger);

        return infoLogger;
    }
    protected static LogSubject buildSubject() {
        LogSubject logSubject = new LogSubject();
        ConsoleLogger consoleLogger = new ConsoleLogger();
        FileLogger fileLogger = new FileLogger();
        DatabaseLogger databaseLogger = new DatabaseLogger();

        logSubject.addObserver(1, consoleLogger);
        logSubject.addObserver(2, consoleLogger);
        logSubject.addObserver(1, fileLogger);
        logSubject.addObserver(2, fileLogger);
        logSubject.addObserver(3, databaseLogger);

        return logSubject;
    }
}
