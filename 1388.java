import java.util.Arrays;

class Solution {
    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        return Math.max(
                solve(Arrays.copyOfRange(slices, 0, n - 1)),
                solve(Arrays.copyOfRange(slices, 1, n)));
    }

    private int solve(int[] arr) {
        int m = arr.length;
        int choose = (m + 1) / 3;
        int[][] dp = new int[m + 2][choose + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j <= choose; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], arr[i] + dp[i + 2][j - 1]);
            }
        }

        return dp[0][choose];
    }
}