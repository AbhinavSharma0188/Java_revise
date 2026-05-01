class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] res = new int[rows * cols][2];
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        
        int len = 0, d = 0, idx = 0;
        int r = rStart, c = cStart;
        res[idx++] = new int[]{r, c};
        
        while (idx < rows * cols) {
            if (d == 0 || d == 2) len++;
            
            for (int i = 0; i < len; i++) {
                r += dirs[d][0];
                c += dirs[d][1];
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    res[idx++] = new int[]{r, c};
                }
            }
            d = (d + 1) % 4;
        }
        
        return res;
    }
}