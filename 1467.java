class Solution {
    private double total = 0;
    private double valid = 0;
    private double[][] comb;

    public double getProbability(int[] balls) {
        int colors = balls.length;
        int sum = 0;
        for (int x : balls) sum += x;

        comb = new double[49][49];
        for (int i = 0; i < 49; i++) {
            comb[i][0] = comb[i][i] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
            }
        }

        dfs(balls, 0, 0, 0, 0, 0, 1.0, sum / 2);
        return valid / total;
    }

    private void dfs(int[] balls, int idx, int count1, int count2,
                     int distinct1, int distinct2,
                     double ways, int half) {
        if (idx == balls.length) {
            if (count1 == half && count2 == half) {
                total += ways;
                if (distinct1 == distinct2) {
                    valid += ways;
                }
            }
            return;
        }

        for (int i = 0; i <= balls[idx]; i++) {
            int j = balls[idx] - i;
            if (count1 + i > half || count2 + j > half) continue;

            dfs(
                balls,
                idx + 1,
                count1 + i,
                count2 + j,
                distinct1 + (i > 0 ? 1 : 0),
                distinct2 + (j > 0 ? 1 : 0),
                ways * comb[balls[idx]][i],
                half
            );
        }
    }
}