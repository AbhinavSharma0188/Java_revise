class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        java.util.Map<Integer, Integer> index = new java.util.HashMap<>();
        for (int i = 0; i < n; i++) index.put(arr[i], i);
        
        int[][] dp = new int[n][n];
        int res = 0;
        
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int prev = arr[j] - arr[i];
                if (prev < arr[i] && index.containsKey(prev)) {
                    int k = index.get(prev);
                    dp[i][j] = dp[k][i] + 1;
                } else {
                    dp[i][j] = 2;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        
        return res > 2 ? res : 0;
    }
}