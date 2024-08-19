package ChainResponsibility_DesignPattern;

public class InfoLogProcessor extends LogProcessor {

    public InfoLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    @Override
    public String log(int logType) {
        if (logType == 1) {
            return "Info log";
        }
        return super.log(logType);
    }
}
