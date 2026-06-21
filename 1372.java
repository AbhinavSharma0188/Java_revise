import javax.swing.tree.TreeNode;

class Solution {
    private int maxLength = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root, -1, 0);
        return maxLength;
    }

    private void dfs(TreeNode node, int direction, int length) {
        if (node == null) {
            return;
        }

        maxLength = Math.max(maxLength, length);

        if (direction != 0) {
            dfs(node.left, 0, length + 1);
        } else {
            dfs(node.left, 0, 1);
        }

        if (direction != 1) {
            dfs(node.right, 1, length + 1);
        } else {
            dfs(node.right, 1, 1);
        }
    }
}