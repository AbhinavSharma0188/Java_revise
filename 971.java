class Solution {
    int i = 0;
    List<Integer> res = new ArrayList<>();

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (dfs(root, voyage)) {
            return res;
        }

        return Arrays.asList(-1);
    }

    private boolean dfs(TreeNode node, int[] voyage) {
        if (node == null) {
            return true;
        }

        if (node.val != voyage[i]) {
            return false;
        }

        i++;

        if (node.left != null && i < voyage.length && node.left.val != voyage[i]) {
            res.add(node.val);
            return dfs(node.right, voyage) && dfs(node.left, voyage);
        }

        return dfs(node.left, voyage) && dfs(node.right, voyage);
    }
}