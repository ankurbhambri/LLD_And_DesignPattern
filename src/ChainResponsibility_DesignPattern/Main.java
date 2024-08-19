package ChainResponsibility_DesignPattern;

public class Main {
    public static void main(String[] args) {
        InfoLogProcessor logProcessor =  new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        System.out.println(logProcessor.log(LogProcessor.INFO));
        System.out.println(logProcessor.log(LogProcessor.DEBUG));
        System.out.println(logProcessor.log(LogProcessor.ERROR));
    }
}
