class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        java.util.List<Integer>[] tree = new java.util.ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            tree[i] = new java.util.ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                tree[manager[i]].add(i);
            }
        }

        return dfs(headID, tree, informTime);
    }

    private int dfs(int node, java.util.List<Integer>[] tree, int[] informTime) {
        int max = 0;

        for (int child : tree[node]) {
            max = Math.max(max, dfs(child, tree, informTime));
        }

        return informTime[node] + max;
    }
}