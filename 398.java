class Solution {
    public int randomPickIndex(int[] nums, int target) {
        int count = 0;
        int res = -1;
        Random rand = new Random();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (rand.nextInt(count) == 0) {
                    res = i;
                }
            }
        }

        return res;
    }
}