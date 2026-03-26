class Solution {
    int idx;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int left, int right) {
        if (left > right) return null;

        int val = postorder[idx--];
        TreeNode node = new TreeNode(val);

        int mid = map.get(val);

        node.right = build(inorder, postorder, mid + 1, right);
        node.left = build(inorder, postorder, left, mid - 1);

        return node;
    }
}