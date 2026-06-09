class Solution {
    private int[][] memo;
    private String word;

    public int minimumDistance(String word) {
        this.word = word;
        int n = word.length();
        memo = new int[n][27];

        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dfs(0, 26);
    }

    private int dfs(int idx, int other) {
        if (idx == word.length() - 1) {
            return 0;
        }

        if (memo[idx][other] != -1) {
            return memo[idx][other];
        }

        int curr = word.charAt(idx) - 'A';
        int next = word.charAt(idx + 1) - 'A';

        int moveCurrent = dist(curr, next) + dfs(idx + 1, other);
        int moveOther = dist(other, next) + dfs(idx + 1, curr);

        return memo[idx][other] = Math.min(moveCurrent, moveOther);
    }

    private int dist(int a, int b) {
        if (a == 26) return 0;

        int r1 = a / 6, c1 = a % 6;
        int r2 = b / 6, c2 = b % 6;

        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}