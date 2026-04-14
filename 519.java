import java.util.*;

class Solution {
    int m, n, total;
    Random rand;
    Map<Integer, Integer> map;

    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        this.total = m * n;
        this.rand = new Random();
        this.map = new HashMap<>();
    }
    
    public int[] flip() {
        int r = rand.nextInt(total);
        total--;
        
        int x = map.getOrDefault(r, r);
        map.put(r, map.getOrDefault(total, total));
        
        return new int[]{x / n, x % n};
    }
    
    public void reset() {
        map.clear();
        total = m * n;
    }
}