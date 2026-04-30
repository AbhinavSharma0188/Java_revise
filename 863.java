class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        buildParent(root, null, parent);
        
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        
        q.offer(target);
        visited.add(target);
        
        int dist = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            if (dist == k) {
                List<Integer> res = new ArrayList<>();
                for (TreeNode node : q) {
                    res.add(node.val);
                }
                return res;
            }
            
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                
                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.offer(curr.left);
                }
                
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.offer(curr.right);
                }
                
                if (parent.get(curr) != null && !visited.contains(parent.get(curr))) {
                    visited.add(parent.get(curr));
                    q.offer(parent.get(curr));
                }
            }
            
            dist++;
        }
        
        return new ArrayList<>();
    }
    
    private void buildParent(TreeNode node, TreeNode par, Map<TreeNode, TreeNode> parent) {
        if (node == null) return;
        
        parent.put(node, par);
        buildParent(node.left, node, parent);
        buildParent(node.right, node, parent);
    }
}