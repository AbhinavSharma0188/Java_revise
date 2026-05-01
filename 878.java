class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        long lcm = ((long)a * b) / gcd(a, b);
        long low = 1, high = (long)n * Math.min(a, b);
        
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (mid / a + mid / b - mid / lcm < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return (int)(low % 1_000_000_007);
    }
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}