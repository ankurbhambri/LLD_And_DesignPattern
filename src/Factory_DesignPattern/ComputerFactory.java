package Factory_DesignPattern;

public class ComputerFactory {

    public IComputer getComputer(String type, String ram, String hdd, String cpu) {
        if("PC".equalsIgnoreCase(type)) return new PC(ram, hdd, cpu);
        else if("Laptop".equalsIgnoreCase(type)) return new Laptop(ram, hdd, cpu);
        return null;
    }
}
