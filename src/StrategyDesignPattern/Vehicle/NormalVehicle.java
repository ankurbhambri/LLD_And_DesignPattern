package StrategyDesignPattern.Vehicle;

import StrategyDesignPattern.DriveStrategy.NormalDrive;

public class NormalVehicle extends Vehicle {
    NormalVehicle() { super( new NormalDrive());}
    }
