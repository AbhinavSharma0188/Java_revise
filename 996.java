class Solution {
    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        return backtrack(nums, new ArrayList<>(), used);
    }

    private int backtrack(int[] nums, List<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            return 1;
        }

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            if (!path.isEmpty()) {
                int sum = path.get(path.size() - 1) + nums[i];
                int sqrt = (int)Math.sqrt(sum);

                if (sqrt * sqrt != sum) {
                    continue;
                }
            }

            used[i] = true;
            path.add(nums[i]);

            count += backtrack(nums, path, used);

            path.remove(path.size() - 1);
            used[i] = false;
        }

        return count;
    }
}