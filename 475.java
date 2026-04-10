import java.util.*;

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int x : matchsticks) sum += x;
        if (sum % 4 != 0) return false;

        int side = sum / 4;
        Arrays.sort(matchsticks);
        int n = matchsticks.length;
        int[] sides = new int[4];

        return backtrack(matchsticks, n - 1, sides, side);
    }

    private boolean backtrack(int[] nums, int index, int[] sides, int target) {
        if (index < 0) {
            return sides[0] == target && sides[1] == target && sides[2] == target && sides[3] == target;
        }

        int val = nums[index];

        for (int i = 0; i < 4; i++) {
            if (sides[i] + val > target) continue;

            sides[i] += val;
            if (backtrack(nums, index - 1, sides, target)) return true;
            sides[i] -= val;

            if (sides[i] == 0) break;
        }

        return false;
    }
}