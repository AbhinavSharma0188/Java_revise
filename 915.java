class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] rightMin = new int[n];

        rightMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(nums[i], rightMin[i + 1]);
        }

        int leftMax = nums[0];

        for (int i = 1; i < n; i++) {
            if (leftMax <= rightMin[i]) return i;
            leftMax = Math.max(leftMax, nums[i]);
        }

        return -1;
    }
}