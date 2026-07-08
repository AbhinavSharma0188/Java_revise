import java.util.*;

class Solution {
    public int[] find_NPV(int[][] npv, int[][] queries) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int[] row : npv) {
            String key = row[0] + "#" + row[1];
            map.put(key, row[2]);
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String key = queries[i][0] + "#" + queries[i][1];
            result[i] = map.getOrDefault(key, 0);
        }

        return result;
    }
}