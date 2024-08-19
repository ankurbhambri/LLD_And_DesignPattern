package VendingMachine_LLD;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    public List[][] board;

    public VendingMachine(Integer machineSize) {
        board = new List[machineSize][machineSize];
        for (int i = 0; i < machineSize; i++) {
            for (int j = 0; j < machineSize; j++) {
                board[i][j] = new ArrayList<>(); // Initialize each cell with a new HashMap
            }
        }
    }

    public void addObjects(String key, Integer val) {

        int[] pos = getFreeSpace(); // Assuming this method returns an int array with row and col
//        if (pos != null) {
//            int row = pos[0];
//            int col = pos[1];
//            board[row][col].put(key, val);
//        }
    }

    public int[] getFreeSpace()
    {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == null) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
