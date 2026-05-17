class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    int originalColor;
    int rows, cols;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        rows = grid.length;
        cols = grid[0].length;
        originalColor = grid[row][col];

        boolean[][] visited = new boolean[rows][cols];
        List<int[]> borders = new ArrayList<>();

        dfs(grid, row, col, visited, borders);

        for (int[] cell : borders) {
            grid[cell[0]][cell[1]] = color;
        }

        return grid;
    }

    private void dfs(int[][] grid, int r, int c, boolean[][] visited, List<int[]> borders) {
        visited[r][c] = true;

        int count = 0;

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols &&
                grid[nr][nc] == originalColor) {

                count++;

                if (!visited[nr][nc]) {
                    dfs(grid, nr, nc, visited, borders);
                }
            }
        }

        if (count < 4) {
            borders.add(new int[]{r, c});
        }
    }
}