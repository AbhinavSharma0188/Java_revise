class Solution {
    public int repeatedNTimes(int[] nums) {
        java.util.HashSet<Integer> set = new java.util.HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }

        return -1;
    }
}