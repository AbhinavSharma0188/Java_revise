import java.util.*;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.peek();
            if (node.right == null || node.right == prev) {
                res.add(node.val);
                stack.pop();
                prev = node;
            } else {
                root = node.right;
            }
        }

        return res;
    }
}