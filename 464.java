class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;
        int sum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;
        if (sum < desiredTotal) return false;
        return dfs(desiredTotal, 0, maxChoosableInteger, new Boolean[1 << maxChoosableInteger]);
    }

    private boolean dfs(int total, int used, int max, Boolean[] dp) {
        if (total <= 0) return false;
        if (dp[used] != null) return dp[used];

        for (int i = 1; i <= max; i++) {
            int mask = 1 << (i - 1);
            if ((used & mask) == 0) {
                if (!dfs(total - i, used | mask, max, dp)) {
                    return dp[used] = true;
                }
            }
        }

        return dp[used] = false;
    }
}