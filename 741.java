class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        
        for (int[] row : dp) Arrays.fill(row, Integer.MIN_VALUE);
        dp[0][0] = grid[0][0];
        
        for (int k = 1; k <= 2 * (n - 1); k++) {
            int[][] newDp = new int[n][n];
            for (int[] row : newDp) Arrays.fill(row, Integer.MIN_VALUE);
            
            for (int i = Math.max(0, k - (n - 1)); i <= Math.min(n - 1, k); i++) {
                for (int j = Math.max(0, k - (n - 1)); j <= Math.min(n - 1, k); j++) {
                    if (grid[i][k - i] == -1 || grid[j][k - j] == -1) continue;
                    
                    int best = dp[i][j];
                    if (i > 0) best = Math.max(best, dp[i - 1][j]);
                    if (j > 0) best = Math.max(best, dp[i][j - 1]);
                    if (i > 0 && j > 0) best = Math.max(best, dp[i - 1][j - 1]);
                    
                    if (best < 0) continue;
                    
                    best += grid[i][k - i];
                    if (i != j) best += grid[j][k - j];
                    
                    newDp[i][j] = best;
                }
            }
            
            dp = newDp;
        }
        
        return Math.max(0, dp[n - 1][n - 1]);
    }
}