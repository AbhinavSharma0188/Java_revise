class Solution {
    public int minimumMoves(int[][] grid) {
        int n = grid.length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][n][2];

        q.offer(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];
            int dir = curr[2];
            int steps = curr[3];

            if (r == n - 1 && c == n - 2 && dir == 0) {
                return steps;
            }

            if (dir == 0) {
                if (c + 2 < n && grid[r][c + 2] == 0 && !visited[r][c + 1][0]) {
                    visited[r][c + 1][0] = true;
                    q.offer(new int[]{r, c + 1, 0, steps + 1});
                }

                if (r + 1 < n && grid[r + 1][c] == 0 && grid[r + 1][c + 1] == 0) {
                    if (!visited[r + 1][c][0]) {
                        visited[r + 1][c][0] = true;
                        q.offer(new int[]{r + 1, c, 0, steps + 1});
                    }

                    if (!visited[r][c][1]) {
                        visited[r][c][1] = true;
                        q.offer(new int[]{r, c, 1, steps + 1});
                    }
                }
            } else {
                if (r + 2 < n && grid[r + 2][c] == 0 && !visited[r + 1][c][1]) {
                    visited[r + 1][c][1] = true;
                    q.offer(new int[]{r + 1, c, 1, steps + 1});
                }

                if (c + 1 < n && grid[r][c + 1] == 0 && grid[r + 1][c + 1] == 0) {
                    if (!visited[r][c + 1][1]) {
                        visited[r][c + 1][1] = true;
                        q.offer(new int[]{r, c + 1, 1, steps + 1});
                    }

                    if (!visited[r][c][0]) {
                        visited[r][c][0] = true;
                        q.offer(new int[]{r, c, 0, steps + 1});
                    }
                }
            }
        }

        return -1;
    }
}