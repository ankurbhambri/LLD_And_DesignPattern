package ChainResponsibility_DesignPattern;

public class ErrorLogProcessor extends LogProcessor{

    public ErrorLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    @Override
    public String log(int logType) {
        if (logType == 2) {
            return "Error log";
        }
        return super.log(logType);
    }
}
