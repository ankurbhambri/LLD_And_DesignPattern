package AbstractFactory_DesignPattern;

public class LuxuryVehicleFactory implements IVehicleFactory{

    @Override
    public IVehicle getVehicle(String name) {
        switch (name)
        {
            case "BMW":
                return new BMW();
            case "Audi":
                return new Audi();
            case "Porsche":
                return new Porsche();
        }
        return null;
    }
}
