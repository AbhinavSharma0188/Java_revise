class Solution {
    public String largestNumber(int[] cost, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int t = 1; t <= target; t++) {
            for (int d = 1; d <= 9; d++) {
                if (t >= cost[d - 1] && dp[t - cost[d - 1]] != Integer.MIN_VALUE) {
                    dp[t] = Math.max(dp[t], dp[t - cost[d - 1]] + 1);
                }
            }
        }

        if (dp[target] < 0) {
            return "0";
        }

        StringBuilder ans = new StringBuilder();
        int t = target;

        for (int d = 9; d >= 1; d--) {
            while (t >= cost[d - 1]
                    && dp[t] == dp[t - cost[d - 1]] + 1) {
                ans.append(d);
                t -= cost[d - 1];
            }
        }

        return ans.toString();
    }
}