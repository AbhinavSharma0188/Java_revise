class Solution {
    int preIndex = 0;
    java.util.Map<Integer, Integer> map = new java.util.HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return build(preorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] postorder, int l, int r) {
        if (l > r) return null;

        TreeNode root = new TreeNode(preorder[preIndex++]);
        if (l == r) return root;

        int index = map.get(preorder[preIndex]);
        root.left = build(preorder, postorder, l, index);
        root.right = build(preorder, postorder, index + 1, r - 1);

        return root;
    }
}