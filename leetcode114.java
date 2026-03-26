class Solution {
    public void flatten(TreeNode root) {
        build(root);
    }

    private TreeNode build(TreeNode node) {
        if (node == null) return null;

        TreeNode leftTail = build(node.left);
        TreeNode rightTail = build(node.right);

        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        if (rightTail != null) return rightTail;
        if (leftTail != null) return leftTail;
        return node;
    }
}