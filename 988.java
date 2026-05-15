class Solution {
    String ans = "~";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return ans;
    }

    private void dfs(TreeNode node, String path) {
        if (node == null) return;

        path = (char)('a' + node.val) + path;

        if (node.left == null && node.right == null) {
            if (path.compareTo(ans) < 0) {
                ans = path;
            }
        }

        dfs(node.left, path);
        dfs(node.right, path);
    }
}