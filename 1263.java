import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    public int minPushBox(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] player = new int[2], box = new int[2], target = new int[2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') player = new int[]{i, j};
                else if (grid[i][j] == 'B') box = new int[]{i, j};
                else if (grid[i][j] == 'T') target = new int[]{i, j};
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Set<String> visited = new HashSet<>();

        pq.offer(new int[]{0, box[0], box[1], player[0], player[1]});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int pushes = cur[0];
            int bx = cur[1], by = cur[2];
            int px = cur[3], py = cur[4];

            String key = bx + "," + by + "," + px + "," + py;
            if (!visited.add(key)) continue;

            if (bx == target[0] && by == target[1]) return pushes;

            for (int[] d : dirs) {
                int pnx = bx - d[0];
                int pny = by - d[1];
                int nbx = bx + d[0];
                int nby = by + d[1];

                if (!isValid(nbx, nby, grid) || !isValid(pnx, pny, grid)) continue;
                if (!canReach(px, py, pnx, pny, bx, by, grid)) continue;

                pq.offer(new int[]{pushes + 1, nbx, nby, bx, by});
            }
        }

        return -1;
    }

    private boolean canReach(int sx, int sy, int tx, int ty, int bx, int by, char[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];

        q.offer(new int[]{sx, sy});
        vis[sx][sy] = true;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == tx && cur[1] == ty) return true;

            for (int[] d : dirs) {
                int nx = cur[0] + d[0];
                int ny = cur[1] + d[1];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n ||
                    vis[nx][ny] || grid[nx][ny] == '#' ||
                    (nx == bx && ny == by)) continue;

                vis[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }

        return false;
    }

    private boolean isValid(int x, int y, char[][] grid) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length
                && grid[x][y] != '#';
    }
}