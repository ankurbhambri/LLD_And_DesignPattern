package DesignStrategyPattern.DriveStrategy;

public class NormalDrive implements IDriveStrategy {
    @Override
    public String drive() {
        return "Normal Drive";
    }
}