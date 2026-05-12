class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return dfs(root, root.val);
    }

    private boolean dfs(TreeNode node, int value) {
        if (node == null) {
            return true;
        }

        if (node.val != value) {
            return false;
        }

        return dfs(node.left, value) && dfs(node.right, value);
    }
}