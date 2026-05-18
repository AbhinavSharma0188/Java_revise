import java.util.*;

class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;

        int[][] items = new int[n][2];

        for (int i = 0; i < n; i++) {
            items[i][0] = values[i];
            items[i][1] = labels[i];
        }

        Arrays.sort(items, (a, b) -> b[0] - a[0]);

        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int count = 0;

        for (int[] item : items) {
            int value = item[0];
            int label = item[1];

            if (map.getOrDefault(label, 0) < useLimit) {
                sum += value;
                map.put(label, map.getOrDefault(label, 0) + 1);
                count++;
            }

            if (count == numWanted) {
                break;
            }
        }

        return sum;
    }
}