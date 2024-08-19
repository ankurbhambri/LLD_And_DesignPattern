package ChainResponsibility_DesignPattern;

public class DebugLogProcessor extends LogProcessor {

    public DebugLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    @Override
    public String log(int logType) {
        if (logType == 3) {
            return "Debug log";
        }
        return super.log(logType);
    }
}
