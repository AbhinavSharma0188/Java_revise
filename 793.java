class Solution {
    public int preimageSizeFZF(int k) {
        return (int)(rightBound(k) - leftBound(k) + 1);
    }
    
    private long leftBound(int k) {
        long l = 0, r = 5L * (k + 1);
        while (l < r) {
            long m = l + (r - l) / 2;
            if (count(m) < k) l = m + 1;
            else r = m;
        }
        return l;
    }
    
    private long rightBound(int k) {
        long l = 0, r = 5L * (k + 1);
        while (l < r) {
            long m = l + (r - l) / 2;
            if (count(m) <= k) l = m + 1;
            else r = m;
        }
        return l - 1;
    }
    
    private long count(long x) {
        long res = 0;
        while (x > 0) {
            x /= 5;
            res += x;
        }
        return res;
    }
}