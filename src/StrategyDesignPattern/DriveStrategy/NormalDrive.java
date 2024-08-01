package StrategyDesignPattern.DriveStrategy;

public class NormalDrive implements IDriveStrategy {
    @Override
    public String drive() {
        return "Normal Drive";
    }
}