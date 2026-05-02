class Solution {
    TreeNode prev = null;
    TreeNode head = null;

    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return head;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        if (prev == null) {
            head = node;
        } else {
            prev.right = node;
        }
        node.left = null;
        prev = node;

        inorder(node.right);
    }
}