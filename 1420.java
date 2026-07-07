class Solution {
    public int numOfArrays(int n, int m, int k) {
        int MOD = 1_000_000_007;

        long[][] dp = new long[k + 1][m + 1];

        for (int max = 1; max <= m; max++) {
            dp[1][max] = 1;
        }

        for (int len = 2; len <= n; len++) {
            long[][] next = new long[k + 1][m + 1];

            for (int cost = 1; cost <= k; cost++) {

                long prefix = 0;

                for (int max = 1; max <= m; max++) {

                    next[cost][max] =
                            (next[cost][max] + dp[cost][max] * max) % MOD;

                    if (cost > 1) {
                        prefix = (prefix + dp[cost - 1][max - 1]) % MOD;
                        next[cost][max] =
                                (next[cost][max] + prefix) % MOD;
                    }
                }
            }

            dp = next;
        }

        long ans = 0;
        for (int max = 1; max <= m; max++) {
            ans = (ans + dp[k][max]) % MOD;
        }

        return (int) ans;
    }
}