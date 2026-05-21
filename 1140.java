class Solution {

    int[][] dp;
    int[] suffix;

    public int stoneGameII(int[] piles) {

        int n = piles.length;

        dp = new int[n][n + 1];
        suffix = new int[n];

        suffix[n - 1] = piles[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return solve(0, 1, piles);
    }

    private int solve(int i, int m, int[] piles) {

        if (i >= piles.length) {
            return 0;
        }

        if (2 * m >= piles.length - i) {
            return suffix[i];
        }

        if (dp[i][m] != 0) {
            return dp[i][m];
        }

        int ans = 0;

        for (int x = 1; x <= 2 * m; x++) {

            ans = Math.max(
                ans,
                suffix[i] - solve(i + x, Math.max(m, x), piles)
            );
        }

        return dp[i][m] = ans;
    }
}