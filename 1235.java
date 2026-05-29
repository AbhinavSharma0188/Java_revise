import java.util.*;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, jobs, dp);
    }

    private int solve(int idx, int[][] jobs, int[] dp) {
        if (idx >= jobs.length) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int next = findNext(idx, jobs);

        int take = jobs[idx][2] + solve(next, jobs, dp);

        int skip = solve(idx + 1, jobs, dp);

        return dp[idx] = Math.max(take, skip);
    }

    private int findNext(int idx, int[][] jobs) {
        int low = idx + 1;
        int high = jobs.length - 1;
        int ans = jobs.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (jobs[mid][0] >= jobs[idx][1]) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}