class Solution {
    public int numWays(int steps, int arrLen) {
        int mod = 1_000_000_007;
        int maxPos = Math.min(arrLen - 1, steps);

        long[] dp = new long[maxPos + 1];
        dp[0] = 1;

        for (int s = 1; s <= steps; s++) {
            long[] next = new long[maxPos + 1];

            for (int pos = 0; pos <= maxPos; pos++) {
                next[pos] = (next[pos] + dp[pos]) % mod;

                if (pos > 0) {
                    next[pos] = (next[pos] + dp[pos - 1]) % mod;
                }

                if (pos < maxPos) {
                    next[pos] = (next[pos] + dp[pos + 1]) % mod;
                }
            }

            dp = next;
        }

        return (int) dp[0];
    }
}