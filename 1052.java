class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        
        int base = 0;
        
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                base += customers[i];
            }
        }
        
        int extra = 0;
        int maxExtra = 0;
        
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 1) {
                extra += customers[i];
            }
            
            if (i >= minutes && grumpy[i - minutes] == 1) {
                extra -= customers[i - minutes];
            }
            
            maxExtra = Math.max(maxExtra, extra);
        }
        
        return base + maxExtra;
    }
}