class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer>[] graph;
    private int[] disc;
    private int[] low;
    private int time = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);

            graph[u].add(v);
            graph[v].add(u);
        }

        disc = new int[n];
        low = new int[n];

        Arrays.fill(disc, -1);

        dfs(0, -1);

        return ans;
    }

    private void dfs(int node, int parent) {
        disc[node] = low[node] = time++;

        for (int nei : graph[node]) {
            if (nei == parent) {
                continue;
            }

            if (disc[nei] == -1) {
                dfs(nei, node);

                low[node] = Math.min(low[node], low[nei]);

                if (low[nei] > disc[node]) {
                    ans.add(Arrays.asList(node, nei));
                }
            } else {
                low[node] = Math.min(low[node], disc[nei]);
            }
        }
    }
}