package Strategy_DesignPattern.Vehicle;

import Strategy_DesignPattern.DriveStrategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle{
    public SportsVehicle() { super (new SportsDriveStrategy()); }
}
