class Solution {
    java.util.Map<Integer, java.util.List<TreeNode>> map = new java.util.HashMap<>();

    public java.util.List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) return new java.util.ArrayList<>();
        if (n == 1) {
            java.util.List<TreeNode> list = new java.util.ArrayList<>();
            list.add(new TreeNode(0));
            return list;
        }
        if (map.containsKey(n)) return map.get(n);

        java.util.List<TreeNode> res = new java.util.ArrayList<>();

        for (int i = 1; i < n; i += 2) {
            java.util.List<TreeNode> left = allPossibleFBT(i);
            java.util.List<TreeNode> right = allPossibleFBT(n - 1 - i);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }

        map.put(n, res);
        return res;
    }
}