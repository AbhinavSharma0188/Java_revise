class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long left = 1;
        long right = 2000000000L;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (count(mid, a, b, c) < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (int) left;
    }

    private long count(long x, long a, long b, long c) {
        long ab = lcm(a, b);
        long bc = lcm(b, c);
        long ac = lcm(a, c);
        long abc = lcm(a, (int) bc);

        return x / a + x / b + x / c
                - x / ab - x / bc - x / ac
                + x / abc;
    }

    private long gcd(long x, long y) {
        while (y != 0) {
            long temp = y;
            y = x % y;
            x = temp;
        }

        return x;
    }

    private long lcm(long x, long y) {
        return (x * y) / gcd(x, y);
    }
}