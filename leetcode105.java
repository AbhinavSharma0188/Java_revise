class Solution {
    int idx = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) return null;

        int val = preorder[idx++];
        TreeNode node = new TreeNode(val);

        int mid = map.get(val);

        node.left = build(preorder, left, mid - 1);
        node.right = build(preorder, mid + 1, right);

        return node;
    }
}