class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];

        for (int i = 0; i < m; i++) {
            for (int j1 = 0; j1 < n; j1++) {
                Arrays.fill(dp[i][j1], -1);
            }
        }

        return dfs(0, 0, n - 1, grid, dp);
    }

    private int dfs(int row, int c1, int c2, int[][] grid, int[][][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        if (c1 < 0 || c1 >= n || c2 < 0 || c2 >= n) {
            return Integer.MIN_VALUE;
        }

        if (dp[row][c1][c2] != -1) {
            return dp[row][c1][c2];
        }

        int cherries = grid[row][c1];
        if (c1 != c2) {
            cherries += grid[row][c2];
        }

        if (row == m - 1) {
            return dp[row][c1][c2] = cherries;
        }

        int max = 0;

        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                max = Math.max(max, dfs(row + 1, c1 + d1, c2 + d2, grid, dp));
            }
        }

        return dp[row][c1][c2] = cherries + max;
    }
}