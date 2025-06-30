package VendingMachine__LLD;

public interface Shell {
    public int getAvailability(String key);
    public boolean popProduct(String key, Integer value);
}
