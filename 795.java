class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }
    
    private int count(int[] nums, int bound) {
        int res = 0, cur = 0;
        
        for (int num : nums) {
            if (num <= bound) {
                cur++;
                res += cur;
            } else {
                cur = 0;
            }
        }
        
        return res;
    }
}