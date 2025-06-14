package Logger__LLD;

import java.io.Serializable;

import static Logger__LLD.LogManager.buildChainOfLoggers;
import static Logger__LLD.LogManager.buildSubject;

public class Logger implements Cloneable, Serializable {

    private volatile static Logger loggerInstance;
    private volatile static AbstractLogger chainOfLoggers;
    private volatile static LogSubject logSubject;

    private Logger(){
        if (loggerInstance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static Logger getInstance() {
        if (loggerInstance == null) {
            synchronized (Logger.class) {
                if (loggerInstance == null) {
                    loggerInstance = new Logger();
                    chainOfLoggers = buildChainOfLoggers();
                    logSubject = buildSubject();
                }
            }
        }
        return loggerInstance;
    }

    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of this class is not allowed");
    }

    protected Object readResolve() {
        return loggerInstance;
    }
    protected void createLog(int level, String msg) {
        chainOfLoggers.logMessage(level, msg, logSubject);
    }
    public void info(String msg) {
        createLog(1, msg);
    }
    public void error(String msg) {
        createLog(2, msg);
    }
    public void debug(String msg) {
        createLog(3, msg);
    }

}
