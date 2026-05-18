import java.util.*;

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                matrix[r][c] += matrix[r][c - 1];
            }
        }

        int count = 0;

        for (int startCol = 0; startCol < cols; startCol++) {
            for (int endCol = startCol; endCol < cols; endCol++) {

                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);

                int sum = 0;

                for (int r = 0; r < rows; r++) {
                    sum += matrix[r][endCol] - (startCol > 0 ? matrix[r][startCol - 1] : 0);

                    count += map.getOrDefault(sum - target, 0);

                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }

        return count;
    }
}