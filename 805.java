import java.util.*;

class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int x : nums) sum += x;

        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) dp.add(new HashSet<>());

        dp.get(0).add(0);

        for (int num : nums) {
            for (int i = n - 1; i >= 1; i--) {
                for (int s : dp.get(i - 1)) {
                    dp.get(i).add(s + num);
                }
            }
        }

        for (int k = 1; k < n; k++) {
            if ((k * sum) % n != 0) continue;

            int target = (k * sum) / n;

            if (dp.get(k).contains(target)) return true;
        }

        return false;
    }
}