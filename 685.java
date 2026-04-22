class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        int[] cand1 = null, cand2 = null;
        int[] indegree = new int[n + 1];

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (indegree[v] == 0) {
                indegree[v] = u;
            } else {
                cand1 = new int[]{indegree[v], v};
                cand2 = edge;
                edge[1] = 0;
            }
        }

        for (int i = 1; i <= n; i++) parent[i] = i;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (v == 0) continue;

            int pu = find(parent, u);
            int pv = find(parent, v);

            if (pu == pv) {
                if (cand1 == null) return edge;
                return cand1;
            }

            parent[pu] = pv;
        }

        return cand2;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}