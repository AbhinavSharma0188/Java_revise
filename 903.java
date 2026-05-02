class Solution {
    public int numPermsDISequence(String s) {
        int n = s.length();
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        java.util.Arrays.fill(dp, 1);

        for (int i = 1; i <= n; i++) {
            int[] next = new int[n + 1];
            if (s.charAt(i - 1) == 'I') {
                int sum = 0;
                for (int j = 0; j < n - i + 1; j++) {
                    sum = (sum + dp[j]) % mod;
                    next[j] = sum;
                }
            } else {
                int sum = 0;
                for (int j = n - i; j >= 0; j--) {
                    sum = (sum + dp[j + 1]) % mod;
                    next[j] = sum;
                }
            }
            dp = next;
        }

        return dp[0];
    }
}