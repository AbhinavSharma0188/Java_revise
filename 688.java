class Solution {
    double[][][] dp;
    int[][] dirs = {
        {2,1},{1,2},{-1,2},{-2,1},
        {-2,-1},{-1,-2},{1,-2},{2,-1}
    };

    public double knightProbability(int n, int k, int row, int col) {
        dp = new double[n][n][k + 1];
        return solve(n, k, row, col);
    }

    private double solve(int n, int k, int r, int c) {
        if (r < 0 || c < 0 || r >= n || c >= n) return 0;
        if (k == 0) return 1;

        if (dp[r][c][k] != 0) return dp[r][c][k];

        double prob = 0;
        for (int[] d : dirs) {
            prob += solve(n, k - 1, r + d[0], c + d[1]) / 8.0;
        }

        dp[r][c][k] = prob;
        return prob;
    }
}