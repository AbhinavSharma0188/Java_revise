class Solution {
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        int mod = 1000000007;
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                
                if (s.charAt(i) == s.charAt(j)) {
                    int low = i + 1, high = j - 1;
                    
                    while (low <= high && s.charAt(low) != s.charAt(i)) low++;
                    while (low <= high && s.charAt(high) != s.charAt(i)) high--;
                    
                    if (low > high) {
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                    } else if (low == high) {
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[low + 1][high - 1];
                    }
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
                
                dp[i][j] = (dp[i][j] % mod + mod) % mod;
            }
        }
        
        return dp[0][n - 1];
    }
}