class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        int totalKeys = 0, startX = 0, startY = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    startX = i;
                    startY = j;
                } else if (c >= 'a' && c <= 'f') {
                    totalKeys++;
                }
            }
        }
        
        int finalMask = (1 << totalKeys) - 1;
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[m][n][1 << totalKeys];
        
        q.offer(new int[]{startX, startY, 0});
        visited[startX][startY][0] = true;
        
        int steps = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            while (size-- > 0) {
                int[] curr = q.poll();
                int x = curr[0], y = curr[1], keys = curr[2];
                
                if (keys == finalMask) return steps;
                
                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                    
                    char c = grid[nx].charAt(ny);
                    if (c == '#') continue;
                    
                    int newKeys = keys;
                    
                    if (c >= 'a' && c <= 'f') {
                        newKeys |= (1 << (c - 'a'));
                    }
                    
                    if (c >= 'A' && c <= 'F') {
                        if ((keys & (1 << (c - 'A'))) == 0) continue;
                    }
                    
                    if (!visited[nx][ny][newKeys]) {
                        visited[nx][ny][newKeys] = true;
                        q.offer(new int[]{nx, ny, newKeys});
                    }
                }
            }
            
            steps++;
        }
        
        return -1;
    }
}