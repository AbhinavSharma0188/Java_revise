class Solution {
    long totalSum = 0;
    long maxProduct = 0;
    static final int MOD = 1000000007;

    public int maxProduct(TreeNode root) {
        totalSum = getSum(root);
        calculate(root);
        return (int) (maxProduct % MOD);
    }

    private long getSum(TreeNode node) {
        if (node == null)
            return 0;
        return node.val + getSum(node.left) + getSum(node.right);
    }

    private long calculate(TreeNode node) {
        if (node == null)
            return 0;

        long subTreeSum = node.val + calculate(node.left) + calculate(node.right);
        maxProduct = Math.max(maxProduct, subTreeSum * (totalSum - subTreeSum));

        return subTreeSum;
    }
}