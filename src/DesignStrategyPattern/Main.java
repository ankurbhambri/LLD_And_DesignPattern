package DesignStrategyPattern;

import DesignStrategyPattern.DriveStrategy.SportsDrive;
import DesignStrategyPattern.Vehicle.Vehicle;

public class Main {

    public static void main(String[] args) {

        // Normal Vehicle with Normal Drive
        Vehicle obj = new Vehicle(new SportsDrive());
        System.out.println(obj.drive());
    }
}