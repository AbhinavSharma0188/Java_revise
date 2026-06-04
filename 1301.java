class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int mod = 1000000007;

        int[][] score = new int[n][n];
        int[][] ways = new int[n][n];

        ways[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                char c = board.get(i).charAt(j);

                if (c == 'X' || (i == n - 1 && j == n - 1)) {
                    continue;
                }

                int maxScore = -1;
                int count = 0;

                int[][] dirs = {{1, 0}, {0, 1}, {1, 1}};

                for (int[] d : dirs) {
                    int ni = i + d[0];
                    int nj = j + d[1];

                    if (ni < n && nj < n && ways[ni][nj] > 0) {
                        if (score[ni][nj] > maxScore) {
                            maxScore = score[ni][nj];
                            count = ways[ni][nj];
                        } else if (score[ni][nj] == maxScore) {
                            count = (count + ways[ni][nj]) % mod;
                        }
                    }
                }

                if (count > 0) {
                    ways[i][j] = count;
                    score[i][j] = maxScore;

                    if (c != 'S' && c != 'E') {
                        score[i][j] += c - '0';
                    }
                }
            }
        }

        if (ways[0][0] == 0) {
            return new int[]{0, 0};
        }

        return new int[]{score[0][0], ways[0][0]};
    }
}