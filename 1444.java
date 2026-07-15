class Solution {
    private static final int MOD = 1000000007;

    public int ways(String[] pizza, int k) {
        int m = pizza.length;
        int n = pizza[0].length();
        int[][] pre = new int[m + 1][n + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                pre[i][j] = pre[i + 1][j] + pre[i][j + 1] - pre[i + 1][j + 1]
                        + (pizza[i].charAt(j) == 'A' ? 1 : 0);
            }
        }

        Integer[][][] memo = new Integer[m][n][k];

        return dfs(0, 0, k - 1, pre, memo);
    }

    private int dfs(int r, int c, int cuts, int[][] pre, Integer[][][] memo) {
        if (pre[r][c] == 0) {
            return 0;
        }

        if (cuts == 0) {
            return 1;
        }

        if (memo[r][c][cuts] != null) {
            return memo[r][c][cuts];
        }

        int ans = 0;
        int m = pre.length - 1;
        int n = pre[0].length - 1;

        for (int nr = r + 1; nr < m; nr++) {
            if (pre[r][c] - pre[nr][c] > 0) {
                ans = (ans + dfs(nr, c, cuts - 1, pre, memo)) % MOD;
            }
        }

        for (int nc = c + 1; nc < n; nc++) {
            if (pre[r][c] - pre[r][nc] > 0) {
                ans = (ans + dfs(r, nc, cuts - 1, pre, memo)) % MOD;
            }
        }

        return memo[r][c][cuts] = ans;
    }
}