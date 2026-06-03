import java.util.*;

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        if (m == 1 && n == 1) return 0;
        if (k >= m + n - 2) return m + n - 2;

        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[m][n][k + 1];

        q.offer(new int[]{0, 0, k});
        visited[0][0][k] = true;

        int steps = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                int rem = curr[2];

                if (r == m - 1 && c == n - 1) return steps;

                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;

                    int nk = rem - grid[nr][nc];

                    if (nk >= 0 && !visited[nr][nc][nk]) {
                        visited[nr][nc][nk] = true;
                        q.offer(new int[]{nr, nc, nk});
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}