class Solution {
    public double largestSumOfAverages(int[] nums, int K) {
        int n = nums.length;

        double[] prefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        double[][] dp = new double[n][K + 1];

        for (int i = 0; i < n; i++) {
            dp[i][1] = (prefix[n] - prefix[i]) / (n - i);
        }

        for (int k = 2; k <= K; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    dp[i][k] = Math.max(
                        dp[i][k],
                        (prefix[j] - prefix[i]) / (j - i) + (j < n ? dp[j][k - 1] : 0)
                    );
                }
            }
        }

        return dp[0][K];
    }
}