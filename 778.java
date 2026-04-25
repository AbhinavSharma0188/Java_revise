class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[n][n];
        
        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;
        
        int res = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int val = curr[0], x = curr[1], y = curr[2];
            
            res = Math.max(res, val);
            
            if (x == n - 1 && y == n - 1) return res;
            
            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    pq.offer(new int[]{grid[nx][ny], nx, ny});
                }
            }
        }
        
        return res;
    }
}