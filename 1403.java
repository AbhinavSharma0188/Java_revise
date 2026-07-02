import java.util.*;

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        List<Integer> result = new ArrayList<>();
        int sum = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            result.add(nums[i]);

            if (sum > total - sum) {
                break;
            }
        }

        return result;
    }
}