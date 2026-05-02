class Solution {
    public int sumSubseqWidths(int[] nums) {
        int mod = 1000000007;
        java.util.Arrays.sort(nums);
        int n = nums.length;

        long[] pow = new long[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + (pow[i] - pow[n - i - 1]) * nums[i]) % mod;
        }

        return (int)((res + mod) % mod);
    }
}