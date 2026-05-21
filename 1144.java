class Solution {

    public int movesToMakeZigzag(int[] nums) {

        return Math.min(helper(nums, 0), helper(nums, 1));
    }

    private int helper(int[] nums, int start) {

        int moves = 0;

        for (int i = start; i < nums.length; i += 2) {

            int left = (i > 0) ? nums[i - 1] : Integer.MAX_VALUE;
            int right = (i + 1 < nums.length) ? nums[i + 1] : Integer.MAX_VALUE;

            int minNeighbour = Math.min(left, right);

            if (nums[i] >= minNeighbour) {

                moves += nums[i] - minNeighbour + 1;
            }
        }

        return moves;
    }
}