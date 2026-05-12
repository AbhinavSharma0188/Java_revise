class Solution {
    int cameras = 0;

    public int minCameraCover(TreeNode root) {
        if (dfs(root) == -1) {
            cameras++;
        }

        return cameras;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 1;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (left == -1 || right == -1) {
            cameras++;
            return 0;
        }

        if (left == 0 || right == 0) {
            return 1;
        }

        return -1;
    }
}