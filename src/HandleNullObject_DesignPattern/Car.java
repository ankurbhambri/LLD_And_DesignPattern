package HandleNullObject_DesignPattern;

public class Car implements Vehicle {

    @Override
    public int getVehicleTankCapacity()
    {
        return 10;
    }

    @Override
    public int getSeatingCapacity() {
        return 6;
    }
}
