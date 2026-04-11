class Solution {
    public java.util.List<Integer> largestValues(TreeNode root) {
        java.util.List<Integer> res = new java.util.ArrayList<>();
        if (root == null) return res;
        
        java.util.Queue<TreeNode> q = new java.util.LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            
            res.add(max);
        }
        
        return res;
    }
}