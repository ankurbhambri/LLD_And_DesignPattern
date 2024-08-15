package Factory_DesignPattern;

public class Main {
    public static void main(String[] args) {
        ComputerFactory computerFactory = new ComputerFactory();
        IComputer pc = computerFactory.getComputer("pc","2 GB","500 GB","2.4 GHz");
        IComputer laptop = computerFactory.getComputer("laptop","16 GB","1 TB","2.9 GHz");
        System.out.println("Factory PC Config:: " + pc);
        System.out.println("Factory Server Config:: " + laptop);
    }
}
