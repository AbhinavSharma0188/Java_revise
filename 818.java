import java.util.*;

class Solution {
    public int racecar(int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return helper(target, dp);
    }

    private int helper(int t, int[] dp) {
        if (dp[t] != -1) return dp[t];

        int k = 1;
        while ((1 << k) - 1 < t) k++;

        if ((1 << k) - 1 == t) {
            dp[t] = k;
            return k;
        }

        int res = k + 1 + helper((1 << k) - 1 - t, dp);

        for (int m = 0; m < k - 1; m++) {
            int dist = (1 << (k - 1)) - 1 - ((1 << m) - 1);
            res = Math.min(res, (k - 1) + 1 + m + 1 + helper(t - dist, dp));
        }

        dp[t] = res;
        return res;
    }
}