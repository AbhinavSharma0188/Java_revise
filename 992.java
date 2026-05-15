class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int[] freq = new int[20001];
        int left = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            if (freq[nums[right]]++ == 0) {
                k--;
            }

            while (k < 0) {
                if (--freq[nums[left++]] == 0) {
                    k++;
                }
            }

            count += right - left + 1;
        }

        return count;
    }
}