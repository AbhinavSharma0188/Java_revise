class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        boolean[] travel = new boolean[366];

        for (int day : days) {
            travel[day] = true;
        }

        for (int i = 1; i <= 365; i++) {
            if (!travel[i]) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.min(
                    dp[i - 1] + costs[0],
                    Math.min(
                        dp[Math.max(0, i - 7)] + costs[1],
                        dp[Math.max(0, i - 30)] + costs[2]
                    )
                );
            }
        }

        return dp[365];
    }
}