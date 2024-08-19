package HandleNullObject_DesignPattern;

public class Bike implements Vehicle {

    @Override
    public int getVehicleTankCapacity() {
        return 4;
    }

    @Override
    public int getSeatingCapacity() {
        return 2;
    }
}
