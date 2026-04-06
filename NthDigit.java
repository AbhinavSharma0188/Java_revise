class Solution {
    public int findNthDigit(int n) {
        long digit = 1;
        long count = 9;
        long start = 1;

        while (n > digit * count) {
            n -= digit * count;
            digit++;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / digit;

        String num = Long.toString(start);
        return num.charAt((n - 1) % (int)digit) - '0';
    }
}