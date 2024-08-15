package AbstractFactory_DesignPattern;

public class AbstractVehicleFactory {
    public IVehicleFactory getFactory (String name) {
        switch (name) {
            case "Luxury": return new LuxuryVehicleFactory();
            case "Ordinary": return new OrdinaryVehicleFactory();
        }
        return null;
    }
}
