class Solution {
    int[][][] dp;
    int n;

    public int catMouseGame(int[][] graph) {
        n = graph.length;
        dp = new int[n][n][2 * n];

        for (int[][] layer : dp)
            for (int[] row : layer)
                Arrays.fill(row, -1);

        return dfs(1, 2, 0, graph);
    }

    private int dfs(int mouse, int cat, int turns, int[][] graph) {
        if (turns == 2 * n) return 0;
        if (mouse == 0) return 1;
        if (cat == mouse) return 2;

        if (dp[mouse][cat][turns] != -1)
            return dp[mouse][cat][turns];

        int curMove = turns % 2;
        if (curMove == 0) {
            boolean catWin = true;
            for (int next : graph[mouse]) {
                int res = dfs(next, cat, turns + 1, graph);
                if (res == 1) return dp[mouse][cat][turns] = 1;
                if (res != 2) catWin = false;
            }
            if (catWin) return dp[mouse][cat][turns] = 2;
            return dp[mouse][cat][turns] = 0;
        } else {
            boolean mouseWin = true;
            for (int next : graph[cat]) {
                if (next == 0) continue;
                int res = dfs(mouse, next, turns + 1, graph);
                if (res == 2) return dp[mouse][cat][turns] = 2;
                if (res != 1) mouseWin = false;
            }
            if (mouseWin) return dp[mouse][cat][turns] = 1;
            return dp[mouse][cat][turns] = 0;
        }
    }
}