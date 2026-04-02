import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int n = nums.length;
        int i = 0;

        while (i < n) {
            int start = nums[i];
            while (i + 1 < n && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            if (start == nums[i]) {
                res.add(String.valueOf(start));
            } else {
                res.add(start + "->" + nums[i]);
            }
            i++;
        }

        return res;
    }
}