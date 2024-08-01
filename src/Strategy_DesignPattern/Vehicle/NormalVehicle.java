package Strategy_DesignPattern.Vehicle;

import Strategy_DesignPattern.DriveStrategy.NormalDriveStrategy;

public class NormalVehicle extends Vehicle {
    public NormalVehicle() { super( new NormalDriveStrategy()); }
}
