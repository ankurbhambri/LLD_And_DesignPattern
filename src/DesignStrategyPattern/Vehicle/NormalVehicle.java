package DesignStrategyPattern.Vehicle;

import DesignStrategyPattern.DriveStrategy.NormalDrive;

public class NormalVehicle extends Vehicle {
    NormalVehicle() { super( new NormalDrive());}
    }
