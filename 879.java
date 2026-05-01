class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int mod = 1000000007;
        int m = group.length;
        
        int[][] dp = new int[minProfit + 1][n + 1];
        dp[0][0] = 1;
        
        for (int i = 0; i < m; i++) {
            int g = group[i];
            int p = profit[i];
            
            for (int j = minProfit; j >= 0; j--) {
                for (int k = n; k >= g; k--) {
                    int newProfit = Math.min(minProfit, j + p);
                    dp[newProfit][k] = (dp[newProfit][k] + dp[j][k - g]) % mod;
                }
            }
        }
        
        int res = 0;
        for (int k = 0; k <= n; k++) {
            res = (res + dp[minProfit][k]) % mod;
        }
        
        return res;
    }
}