class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int ans = 0;

        for (int num : nums) {
            sum += num;

            ans += map.getOrDefault(sum - goal, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}