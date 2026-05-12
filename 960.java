class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        int[] dp = new int[m];
        int max = 1;

        for (int i = 0; i < m; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                boolean valid = true;

                for (int k = 0; k < n; k++) {
                    if (strs[k].charAt(j) > strs[k].charAt(i)) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            max = Math.max(max, dp[i]);
        }

        return m - max;
    }
}