package HandleNullObject_DesignPattern;

import java.util.Objects;

public class VehicleFactory {

    public static Vehicle getVehicle(String type) {
        if (Objects.equals(type, "Bike")) {
            return new Bike();
        }
        else if (Objects.equals(type, "Car")) {
            return new Car();
        }
        return new NullVehicle();
    }
}
