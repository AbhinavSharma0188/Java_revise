class Solution {
    int paths = 0;
    int empty = 0;

    public int uniquePathsIII(int[][] grid) {
        int startX = 0;
        int startY = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    empty++;
                } else if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }

        dfs(grid, startX, startY, -1);

        return paths;
    }

    private void dfs(int[][] grid, int x, int y, int count) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1) {
            return;
        }

        if (grid[x][y] == 2) {
            if (count == empty) {
                paths++;
            }
            return;
        }

        int temp = grid[x][y];
        grid[x][y] = -1;

        dfs(grid, x + 1, y, count + 1);
        dfs(grid, x - 1, y, count + 1);
        dfs(grid, x, y + 1, count + 1);
        dfs(grid, x, y - 1, count + 1);

        grid[x][y] = temp;
    }
}