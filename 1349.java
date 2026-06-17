class Solution {
    public int maxStudents(char[][] seats) {
        int m = seats.length, n = seats[0].length;
        int[] valid = new int[m];

        for (int i = 0; i < m; i++) {
            int mask = 0;
            for (int j = 0; j < n; j++) {
                if (seats[i][j] == '.')
                    mask |= (1 << j);
            }
            valid[i] = mask;
        }

        int[][] dp = new int[m + 1][1 << n];

        for (int row = 1; row <= m; row++) {
            for (int mask = 0; mask < (1 << n); mask++) {
                if ((mask & ~valid[row - 1]) != 0) continue;
                if ((mask & (mask << 1)) != 0) continue;

                int students = Integer.bitCount(mask);

                for (int prev = 0; prev < (1 << n); prev++) {
                    if ((mask & (prev << 1)) != 0) continue;
                    if ((mask & (prev >> 1)) != 0) continue;

                    dp[row][mask] = Math.max(
                        dp[row][mask],
                        dp[row - 1][prev] + students
                    );
                }
            }
        }

        int ans = 0;
        for (int val : dp[m]) {
            ans = Math.max(ans, val);
        }
        return ans;
    }
}