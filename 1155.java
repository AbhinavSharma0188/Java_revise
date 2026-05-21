class Solution {

    int MOD = 1000000007;
    Integer[][] dp;

    public int numRollsToTarget(int n, int k, int target) {

        dp = new Integer[n + 1][target + 1];

        return solve(n, k, target);
    }

    private int solve(int dice, int faces, int target) {

        if (dice == 0 && target == 0) {
            return 1;
        }

        if (dice == 0 || target < 0) {
            return 0;
        }

        if (dp[dice][target] != null) {
            return dp[dice][target];
        }

        long ways = 0;

        for (int i = 1; i <= faces; i++) {

            ways += solve(dice - 1, faces, target - i);

            ways %= MOD;
        }

        return dp[dice][target] = (int) ways;
    }
}