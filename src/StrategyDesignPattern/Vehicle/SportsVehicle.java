package StrategyDesignPattern.Vehicle;

import StrategyDesignPattern.DriveStrategy.SportsDrive;

public class SportsVehicle extends Vehicle{
    SportsVehicle() {super (new SportsDrive());}
}
