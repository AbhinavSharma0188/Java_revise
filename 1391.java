class Solution {
    private final int[][][] dirs = {
        {},
        {{0, -1}, {0, 1}},
        {{-1, 0}, {1, 0}},
        {{0, -1}, {1, 0}},
        {{0, 1}, {1, 0}},
        {{0, -1}, {-1, 0}},
        {{0, 1}, {-1, 0}}
    };

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            if (r == m - 1 && c == n - 1) {
                return true;
            }

            for (int[] d : dirs[grid[r][c]]) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc]) {
                    continue;
                }

                for (int[] back : dirs[grid[nr][nc]]) {
                    if (nr + back[0] == r && nc + back[1] == c) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                        break;
                    }
                }
            }
        }

        return false;
    }
}