import java.util.*;

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();

        for (int[] row : matrix) {
            StringBuilder sb = new StringBuilder();

            for (int num : row) {
                sb.append(num ^ row[0]);
            }

            String key = sb.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int max = 0;

        for (int val : map.values()) {
            max = Math.max(max, val);
        }

        return max;
    }
}