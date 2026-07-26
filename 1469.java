class Solution {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> getLonelyNodes(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;

        if (node.left != null && node.right == null) {
            ans.add(node.left.val);
        }

        if (node.right != null && node.left == null) {
            ans.add(node.right.val);
        }

        dfs(node.left);
        dfs(node.right);
    }
}