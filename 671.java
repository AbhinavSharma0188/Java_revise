class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        long ans = dfs(root, root.val);
        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }

    private long dfs(TreeNode node, int min) {
        if (node == null) return Long.MAX_VALUE;

        if (node.val > min) return node.val;

        long left = dfs(node.left, min);
        long right = dfs(node.right, min);

        return Math.min(left, right);
    }
}