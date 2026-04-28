import java.util.*;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);

        int i = 0, maxProfit = 0, res = 0;

        for (int w : worker) {
            while (i < n && jobs[i][0] <= w) {
                maxProfit = Math.max(maxProfit, jobs[i][1]);
                i++;
            }
            res += maxProfit;
        }

        return res;
    }
}