class Solution {
    public int findMinMoves(int[] machines) {
        int total = 0;
        for (int m : machines) total += m;
        
        if (total % machines.length != 0) return -1;
        
        int avg = total / machines.length;
        int res = 0, curr = 0;
        
        for (int m : machines) {
            curr += m - avg;
            res = Math.max(res, Math.max(Math.abs(curr), m - avg));
        }
        
        return res;
    }
}