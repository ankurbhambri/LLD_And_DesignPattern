package DesignStrategyPattern.Vehicle;

import DesignStrategyPattern.DriveStrategy.IDriveStrategy;



public class Vehicle {

    IDriveStrategy driveStrategy;
    // Constructor Injection
    public Vehicle(IDriveStrategy obj) {
        this.driveStrategy = obj;
    }

    public String drive()
    {
        return driveStrategy.drive();
    }
}
