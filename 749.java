class Solution {
    public int containVirus(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        
        while (true) {
            boolean[][] visited = new boolean[m][n];
            List<List<int[]>> regions = new ArrayList<>();
            List<Set<Integer>> frontiers = new ArrayList<>();
            List<Integer> walls = new ArrayList<>();
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        List<int[]> cells = new ArrayList<>();
                        Set<Integer> frontier = new HashSet<>();
                        int[] wall = new int[1];
                        dfs(grid, i, j, visited, cells, frontier, wall);
                        regions.add(cells);
                        frontiers.add(frontier);
                        walls.add(wall[0]);
                    }
                }
            }
            
            if (regions.isEmpty()) break;
            
            int idx = 0;
            for (int i = 1; i < frontiers.size(); i++) {
                if (frontiers.get(i).size() > frontiers.get(idx).size()) {
                    idx = i;
                }
            }
            
            res += walls.get(idx);
            
            for (int i = 0; i < regions.size(); i++) {
                if (i == idx) {
                    for (int[] cell : regions.get(i)) {
                        grid[cell[0]][cell[1]] = -1;
                    }
                } else {
                    for (int code : frontiers.get(i)) {
                        int r = code / n, c = code % n;
                        grid[r][c] = 1;
                    }
                }
            }
        }
        
        return res;
    }
    
    private void dfs(int[][] grid, int r, int c, boolean[][] visited,
                     List<int[]> cells, Set<Integer> frontier, int[] wall) {
        int m = grid.length, n = grid[0].length;
        if (r < 0 || c < 0 || r >= m || c >= n || visited[r][c] || grid[r][c] != 1) return;
        
        visited[r][c] = true;
        cells.add(new int[]{r, c});
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        for (int[] d : dirs) {
            int nr = r + d[0], nc = c + d[1];
            
            if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
            
            if (grid[nr][nc] == 0) {
                wall[0]++;
                frontier.add(nr * n + nc);
            } else if (grid[nr][nc] == 1) {
                dfs(grid, nr, nc, visited, cells, frontier, wall);
            }
        }
    }
}