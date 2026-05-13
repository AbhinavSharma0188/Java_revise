class Solution {
    public int countTriplets(int[] nums) {
        int[] count = new int[1 << 16];

        for (int a : nums) {
            for (int b : nums) {
                count[a & b]++;
            }
        }

        int res = 0;

        for (int c : nums) {
            for (int mask = 0; mask < (1 << 16); mask++) {
                if ((c & mask) == 0) {
                    res += count[mask];
                }
            }
        }

        return res;
    }
}