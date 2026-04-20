class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    public void helper(Node root, List<Integer> result) {
        if (root == null) return;

        for (Node child : root.children) {
            helper(child, result);
        }

        result.add(root.val);
    }
}