package DesignStrategyPattern.Vehicle;

import DesignStrategyPattern.DriveStrategy.SportsDrive;

public class SportsVehicle extends Vehicle{
    SportsVehicle() {super (new SportsDrive());}
}
