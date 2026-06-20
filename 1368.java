import java.util.*;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerFirst(new int[]{0, 0});
        dist[0][0] = 0;

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int r = cur[0], c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;

                int cost = dist[r][c] + (grid[r][c] == i + 1 ? 0 : 1);

                if (cost < dist[nr][nc]) {
                    dist[nr][nc] = cost;

                    if (grid[r][c] == i + 1) {
                        dq.offerFirst(new int[]{nr, nc});
                    } else {
                        dq.offerLast(new int[]{nr, nc});
                    }
                }
            }
        }

        return dist[m - 1][n - 1];
    }
}