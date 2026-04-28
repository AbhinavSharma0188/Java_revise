class Solution {
    int n;
    
    public int largestIsland(int[][] grid) {
        n = grid.length;
        Map<Integer, Integer> map = new HashMap<>();
        int id = 2;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    map.put(id, dfs(grid, i, j, id));
                    id++;
                }
            }
        }

        int res = 0;
        for (int val : map.values()) res = Math.max(res, val);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    int size = 1;

                    if (i > 0) set.add(grid[i - 1][j]);
                    if (i < n - 1) set.add(grid[i + 1][j]);
                    if (j > 0) set.add(grid[i][j - 1]);
                    if (j < n - 1) set.add(grid[i][j + 1]);

                    for (int key : set) {
                        size += map.getOrDefault(key, 0);
                    }

                    res = Math.max(res, size);
                }
            }
        }

        return res == 0 ? n * n : res;
    }

    private int dfs(int[][] grid, int i, int j, int id) {
        if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] != 1) return 0;
        
        grid[i][j] = id;
        int size = 1;

        size += dfs(grid, i + 1, j, id);
        size += dfs(grid, i - 1, j, id);
        size += dfs(grid, i, j + 1, id);
        size += dfs(grid, i, j - 1, id);

        return size;
    }
}