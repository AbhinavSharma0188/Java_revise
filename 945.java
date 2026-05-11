class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        int moves = 0;
        int next = 0;

        for (int num : nums) {
            if (num < next) {
                moves += next - num;
            } else {
                next = num;
            }

            next++;
        }

        return moves;
    }
}