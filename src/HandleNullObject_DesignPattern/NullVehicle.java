package HandleNullObject_DesignPattern;

public class NullVehicle implements Vehicle {
    @Override
    public int getVehicleTankCapacity() {
        return 0;
    }

    @Override
    public int getSeatingCapacity() {
        return 0;
    }
}
