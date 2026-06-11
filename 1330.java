class Solution {
    public int maxValueAfterReverse(int[] nums) {
        int n = nums.length;
        int total = 0;

        for (int i = 0; i < n - 1; i++) {
            total += Math.abs(nums[i] - nums[i + 1]);
        }

        int gain = 0;
        int minHigh = Integer.MAX_VALUE;
        int maxLow = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            gain = Math.max(gain,
                    Math.abs(nums[0] - nums[i + 1]) - Math.abs(nums[i] - nums[i + 1]));
            gain = Math.max(gain,
                    Math.abs(nums[n - 1] - nums[i]) - Math.abs(nums[i] - nums[i + 1]));

            minHigh = Math.min(minHigh, Math.max(nums[i], nums[i + 1]));
            maxLow = Math.max(maxLow, Math.min(nums[i], nums[i + 1]));
        }

        gain = Math.max(gain, 2 * (maxLow - minHigh));

        return total + gain;
    }
}