package VendingMachine__LLD;

import java.util.Map;

public interface Shell {
    public int getAvailability(String key);
    public boolean popProduct(String key, Integer value);
}
