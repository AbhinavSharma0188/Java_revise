class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] target = count(n);
        
        for (int i = 0; i < 31; i++) {
            if (matches(target, count(1 << i))) {
                return true;
            }
        }
        
        return false;
    }
    
    private int[] count(int n) {
        int[] freq = new int[10];
        while (n > 0) {
            freq[n % 10]++;
            n /= 10;
        }
        return freq;
    }
    
    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 10; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}