class Solution {
    public int knightDialer(int n) {
        int mod = 1000000007;

        int[][] moves = {
            {4, 6},
            {6, 8},
            {7, 9},
            {4, 8},
            {0, 3, 9},
            {},
            {0, 1, 7},
            {2, 6},
            {1, 3},
            {2, 4}
        };

        long[] dp = new long[10];

        java.util.Arrays.fill(dp, 1);

        for (int step = 2; step <= n; step++) {
            long[] next = new long[10];

            for (int i = 0; i < 10; i++) {
                for (int move : moves[i]) {
                    next[i] = (next[i] + dp[move]) % mod;
                }
            }

            dp = next;
        }

        long ans = 0;

        for (long val : dp) {
            ans = (ans + val) % mod;
        }

        return (int) ans;
    }
}