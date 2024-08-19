package HandleNullObject_DesignPattern;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicleFactory = VehicleFactory.getVehicle("Bus");
        printVehicleDetails(vehicleFactory);
    }

    private static void printVehicleDetails(Vehicle vehicle) {
        System.out.println("Seating capacity " + vehicle.getSeatingCapacity());
        System.out.println("Fuel tank capacity " + vehicle.getVehicleTankCapacity());
    }
}
