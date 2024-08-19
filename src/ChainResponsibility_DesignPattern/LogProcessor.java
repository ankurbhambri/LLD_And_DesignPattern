package ChainResponsibility_DesignPattern;

public abstract class LogProcessor {
    public static int INFO = 1;
    public static int ERROR = 2;
    public static int DEBUG = 3;

    private final LogProcessor nextLogProcessor;

    public LogProcessor(LogProcessor nextLogProcessor) {
        this.nextLogProcessor = nextLogProcessor;
    }

    public String log(int logType) {
        if (nextLogProcessor != null) {
            return nextLogProcessor.log(logType);
        }
        return null;
    }
}
