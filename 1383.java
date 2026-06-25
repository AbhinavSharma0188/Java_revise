import java.util.*;

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod = 1_000_000_007;

        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i][0] = efficiency[i];
            engineers[i][1] = speed[i];
        }

        Arrays.sort(engineers, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long speedSum = 0;
        long maxPerformance = 0;

        for (int[] engineer : engineers) {
            int eff = engineer[0];
            int spd = engineer[1];

            if (minHeap.size() == k) {
                speedSum -= minHeap.poll();
            }

            minHeap.offer(spd);
            speedSum += spd;

            maxPerformance = Math.max(maxPerformance, speedSum * eff);
        }

        return (int) (maxPerformance % mod);
    }
}