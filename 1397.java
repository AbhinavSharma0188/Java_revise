class Solution {

    private static final int MOD = 1_000_000_007;
    private String s1, s2, evil;
    private int n, m;
    private int[] lps;
    private Integer[][][][] dp;

    public int findGoodStrings(int n, String s1, String s2, String evil) {
        this.n = n;
        this.s1 = s1;
        this.s2 = s2;
        this.evil = evil;
        this.m = evil.length();

        buildLPS();

        dp = new Integer[n + 1][m + 1][2][2];

        return dfs(0, 0, 1, 1);
    }

    private int dfs(int pos, int matched, int low, int high) {
        if (matched == m) {
            return 0;
        }

        if (pos == n) {
            return 1;
        }

        if (dp[pos][matched][low][high] != null) {
            return dp[pos][matched][low][high];
        }

        char from = low == 1 ? s1.charAt(pos) : 'a';
        char to = high == 1 ? s2.charAt(pos) : 'z';

        long ans = 0;

        for (char ch = from; ch <= to; ch++) {
            int nextMatched = matched;

            while (nextMatched > 0 && evil.charAt(nextMatched) != ch) {
                nextMatched = lps[nextMatched - 1];
            }

            if (evil.charAt(nextMatched) == ch) {
                nextMatched++;
            }

            ans += dfs(
                    pos + 1,
                    nextMatched,
                    (low == 1 && ch == from) ? 1 : 0,
                    (high == 1 && ch == to) ? 1 : 0
            );

            ans %= MOD;
        }

        return dp[pos][matched][low][high] = (int) ans;
    }

    private void buildLPS() {
        lps = new int[m];

        for (int i = 1, len = 0; i < m; ) {
            if (evil.charAt(i) == evil.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
    }
}