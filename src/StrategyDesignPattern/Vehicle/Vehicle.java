package StrategyDesignPattern.Vehicle;

import StrategyDesignPattern.DriveStrategy.IDriveStrategy;



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
