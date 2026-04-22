class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int maxLen = 0, curr = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                curr++;
            } else {
                curr = 1;
            }
            maxLen = Math.max(maxLen, curr);
        }

        return maxLen;
    }
}