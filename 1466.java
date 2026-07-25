class Solution {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : connections) {
            graph[edge[0]].add(new int[]{edge[1], 1});
            graph[edge[1]].add(new int[]{edge[0], 0});
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    private int dfs(int node, List<int[]>[] graph, boolean[] visited) {
        visited[node] = true;
        int changes = 0;

        for (int[] next : graph[node]) {
            int nei = next[0];
            int cost = next[1];

            if (!visited[nei]) {
                changes += cost;
                changes += dfs(nei, graph, visited);
            }
        }

        return changes;
    }
}