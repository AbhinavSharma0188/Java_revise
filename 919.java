import java.util.*;

class CBTInserter {
    Queue<TreeNode> q;

    public CBTInserter(TreeNode root) {
        q = new LinkedList<>();
        Queue<TreeNode> temp = new LinkedList<>();
        temp.offer(root);

        while (!temp.isEmpty()) {
            TreeNode node = temp.poll();
            if (node.left == null || node.right == null) {
                q.offer(node);
            }
            if (node.left != null) temp.offer(node.left);
            if (node.right != null) temp.offer(node.right);
        }
    }

    public int insert(int val) {
        TreeNode parent = q.peek();
        TreeNode newNode = new TreeNode(val);
        if (parent.left == null) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
            q.poll();
        }
        q.offer(newNode);
        return parent.val;
    }

    public TreeNode get_root() {
        return q.peek();
    }
}