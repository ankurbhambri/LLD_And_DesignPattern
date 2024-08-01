package Strategy_DesignPattern.DriveStrategy;

public class NormalDriveStrategy implements IDriveStrategy {
    @Override
    public String drive() {
        return "Normal Drive";
    }
}