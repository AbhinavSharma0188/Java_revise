import java.util.*;

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] d = new int[]{
            dist(p1, p2),
            dist(p1, p3),
            dist(p1, p4),
            dist(p2, p3),
            dist(p2, p4),
            dist(p3, p4)
        };
        
        Arrays.sort(d);
        
        return d[0] > 0 &&
               d[0] == d[1] &&
               d[1] == d[2] &&
               d[2] == d[3] &&
               d[4] == d[5];
    }
    
    private int dist(int[] a, int[] b) {
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        return x * x + y * y;
    }
}