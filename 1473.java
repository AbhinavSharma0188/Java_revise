class Solution {

    private static final int INF = 1000000000;
    private int[] houses;
    private int[][] cost;
    private int m, n, target;
    private Integer[][][] dp;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.houses = houses;
        this.cost = cost;
        this.m = m;
        this.n = n;
        this.target = target;
        dp = new Integer[m][n + 1][target + 1];

        int ans = dfs(0, 0, 0);
        return ans >= INF ? -1 : ans;
    }

    private int dfs(int idx, int prevColor, int neighborhoods) {
        if (neighborhoods > target) {
            return INF;
        }

        if (idx == m) {
            return neighborhoods == target ? 0 : INF;
        }

        if (dp[idx][prevColor][neighborhoods] != null) {
            return dp[idx][prevColor][neighborhoods];
        }

        int res = INF;

        if (houses[idx] != 0) {
            int newNeighborhoods = neighborhoods + (houses[idx] != prevColor ? 1 : 0);
            res = dfs(idx + 1, houses[idx], newNeighborhoods);
        } else {
            for (int color = 1; color <= n; color++) {
                int newNeighborhoods = neighborhoods + (color != prevColor ? 1 : 0);
                res = Math.min(res, cost[idx][color - 1] + dfs(idx + 1, color, newNeighborhoods));
            }
        }

        return dp[idx][prevColor][neighborhoods] = res;
    }
}