package VendingMachine_LLD;

import java.util.Map;

public class VendingShells implements Shell {

    private Map<String, Integer> shellObjects;

    @Override
    public int getAvailability(String key) {
        return shellObjects.getOrDefault(key, 0);
    }

    @Override
    public boolean popProduct(String key, Integer value) {
        if (shellObjects.containsKey(key)) {
            shellObjects.put(key, value);
            return true;
        }
         return false;
    }
}
