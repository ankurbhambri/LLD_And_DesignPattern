package AbstractFactory_DesignPattern;

public class OrdinaryVehicleFactory implements IVehicleFactory{

    @Override
    public IVehicle getVehicle(String name) {
        switch (name)
        {
        case "Swift":
            return new Swift();
        case "Tata":
            return new Swift();
        }
        return null;
    }
}
