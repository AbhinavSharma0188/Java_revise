class Solution {

    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public int shortestBridge(int[][] grid) {
        int n = grid.length;

        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (found) break;

            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    found = true;
                    break;
                }
            }
        }

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] curr = queue.poll();

                for (int[] dir : directions) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
                        if (grid[nr][nc] == 1) {
                            return steps;
                        }

                        if (grid[nr][nc] == 0) {
                            grid[nr][nc] = -1;
                            queue.offer(new int[]{nr, nc});
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    private void dfs(int[][] grid, int r, int c, java.util.Queue<int[]> queue) {
        int n = grid.length;

        if (r < 0 || c < 0 || r >= n || c >= n || grid[r][c] != 1) {
            return;
        }

        grid[r][c] = -1;
        queue.offer(new int[]{r, c});

        for (int[] dir : directions) {
            dfs(grid, r + dir[0], c + dir[1], queue);
        }
    }
}