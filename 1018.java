class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int current = 0;

        for (int num : nums) {
            current = ((current << 1) + num) % 5;
            ans.add(current == 0);
        }

        return ans;
    }
}