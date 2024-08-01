package Strategy_DesignPattern;

import Strategy_DesignPattern.Vehicle.NormalVehicle;
import Strategy_DesignPattern.Vehicle.SportsVehicle;
import Strategy_DesignPattern.Vehicle.Vehicle;

public class Main {

    public static void main(String[] args) {

        Vehicle obj1 = new NormalVehicle();
        System.out.println(obj1.drive());

        Vehicle obj2 = new SportsVehicle();
        System.out.println(obj2.drive());
    }
}