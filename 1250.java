class Solution {
    public boolean isGoodArray(int[] nums) {

        int gcdValue = nums[0];

        for (int num : nums) {
            gcdValue = gcd(gcdValue, num);
        }

        return gcdValue == 1;
    }

    private int gcd(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}