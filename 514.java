class Solution {
    public int findRotateSteps(String ring, String key) {
        int m = ring.length(), n = key.length();
        java.util.Map<Character, java.util.List<Integer>> map = new java.util.HashMap<>();
        
        for (int i = 0; i < m; i++) {
            char c = ring.charAt(i);
            map.computeIfAbsent(c, k -> new java.util.ArrayList<>()).add(i);
        }
        
        int[][] dp = new int[n + 1][m];
        for (int i = 0; i <= n; i++) java.util.Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        
        for (int i = 0; i < m; i++) dp[n][i] = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                for (int k : map.get(key.charAt(i))) {
                    int diff = Math.abs(j - k);
                    int step = Math.min(diff, m - diff);
                    dp[i][j] = Math.min(dp[i][j], step + 1 + dp[i + 1][k]);
                }
            }
        }
        
        return dp[0][0];
    }
}