package AbstractFactory_DesignPattern;

public class Main {
    public static void main(String[] args) {

        AbstractVehicleFactory abstractVehicleFactory = new AbstractVehicleFactory();

        IVehicleFactory ordinaryFactory = abstractVehicleFactory.getFactory("Ordinary");
        IVehicleFactory luxuryFactory = abstractVehicleFactory.getFactory("Luxury");

        IVehicle swift = ordinaryFactory.getVehicle("Swift");
        System.out.println("Swift average :: " + swift.getAverage());

        IVehicle BMW = luxuryFactory.getVehicle("BMW");
        System.out.println("BMW average :: " + BMW.getAverage());
    }
}
