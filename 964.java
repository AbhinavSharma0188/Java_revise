class Solution {
    public int leastOpsExpressTarget(int x, int target) {
        return dfs(x, target, new java.util.HashMap<>());
    }

    private int dfs(int x, int target, java.util.Map<Integer, Integer> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        if (target == 0) {
            return 0;
        }

        if (target < x) {
            return Math.min(target * 2 - 1, (x - target) * 2);
        }

        long power = x;
        int k = 0;

        while (power < target) {
            power *= x;
            k++;
        }

        if (power == target) {
            memo.put(target, k);
            return k;
        }

        int left = k + dfs(x, (int)(target - power / x), memo);

        int right = Integer.MAX_VALUE;

        if (power - target < target) {
            right = k + 1 + dfs(x, (int)(power - target), memo);
        }

        int ans = Math.min(left, right) + 1;

        memo.put(target, ans);
        return ans;
    }
}