import java.util.*;

class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currentDepth = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            if (currentDepth == depth - 1) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    
                    TreeNode tempLeft = node.left;
                    TreeNode tempRight = node.right;
                    
                    node.left = new TreeNode(val);
                    node.left.left = tempLeft;
                    
                    node.right = new TreeNode(val);
                    node.right.right = tempRight;
                }
                break;
            }
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            currentDepth++;
        }
        
        return root;
    }
}