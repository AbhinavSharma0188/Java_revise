class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        int mod = 1000000007;

        long[][][] dp = new long[n + 1][6][16];

        for (int j = 0; j < 6; j++) {
            dp[1][j][1] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 6; j++) {

                for (int p = 0; p < 6; p++) {

                    if (p != j) {

                        for (int cnt = 1; cnt <= rollMax[p]; cnt++) {
                            dp[i][j][1] =
                                (dp[i][j][1] + dp[i - 1][p][cnt]) % mod;
                        }

                    } else {

                        for (int cnt = 2; cnt <= rollMax[j]; cnt++) {
                            dp[i][j][cnt] =
                                (dp[i][j][cnt] + dp[i - 1][j][cnt - 1]) % mod;
                        }
                    }
                }
            }
        }

        long ans = 0;

        for (int j = 0; j < 6; j++) {
            for (int cnt = 1; cnt <= rollMax[j]; cnt++) {
                ans = (ans + dp[n][j][cnt]) % mod;
            }
        }

        return (int) ans;
    }
}