import java.util.*;

public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString().trim();
    }

    private void preorder(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.val).append(" ");
        preorder(node.left, sb);
        preorder(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] arr = data.split(" ");
        Queue<Integer> q = new LinkedList<>();
        for (String s : arr) q.offer(Integer.parseInt(s));
        return build(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(Queue<Integer> q, int min, int max) {
        if (q.isEmpty()) return null;
        int val = q.peek();
        if (val < min || val > max) return null;
        q.poll();
        TreeNode node = new TreeNode(val);
        node.left = build(q, min, val);
        node.right = build(q, val, max);
        return node;
    }
}