class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }

    private void traverse(Node node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        for (Node child : node.children) {
            traverse(child, res);
        }
    }
}