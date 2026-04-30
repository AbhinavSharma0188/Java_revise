class Solution {
    public int matrixScore(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] ^= 1;
                }
            }
        }
        
        int result = 0;
        
        for (int j = 0; j < m; j++) {
            int ones = 0;
            
            for (int i = 0; i < n; i++) {
                if (grid[i][j] == 1) ones++;
            }
            
            int maxOnes = Math.max(ones, n - ones);
            result += maxOnes * (1 << (m - j - 1));
        }
        
        return result;
    }
}