class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        return dfs(0, -1, graph, hasApple);
    }

    private int dfs(int node, int parent, List<Integer>[] graph, List<Boolean> hasApple) {
        int time = 0;

        for (int neighbor : graph[node]) {
            if (neighbor == parent) {
                continue;
            }

            int childTime = dfs(neighbor, node, graph, hasApple);

            if (childTime > 0 || hasApple.get(neighbor)) {
                time += childTime + 2;
            }
        }

        return time;
    }
}