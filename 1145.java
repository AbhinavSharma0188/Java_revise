class Solution {

    int left = 0;
    int right = 0;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {

        count(root, x);

        int parentSide = n - (left + right + 1);

        int maxRegion = Math.max(parentSide, Math.max(left, right));

        return maxRegion > n / 2;
    }

    private int count(TreeNode node, int x) {

        if (node == null) {
            return 0;
        }

        int l = count(node.left, x);
        int r = count(node.right, x);

        if (node.val == x) {
            left = l;
            right = r;
        }

        return l + r + 1;
    }
}