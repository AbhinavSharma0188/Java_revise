class Solution {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] colors = new int[n];
        int color = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, colors, i, color++);
            }
        }

        int[] size = new int[color];
        for (int c : colors) size[c]++;

        int[] infected = new int[color];
        for (int node : initial) infected[colors[node]]++;

        int ans = Integer.MAX_VALUE;
        int maxSaved = -1;

        java.util.Arrays.sort(initial);

        for (int node : initial) {
            int c = colors[node];
            if (infected[c] == 1) {
                if (size[c] > maxSaved) {
                    maxSaved = size[c];
                    ans = node;
                }
            }
        }

        return ans == Integer.MAX_VALUE ? initial[0] : ans;
    }

    private void dfs(int[][] graph, boolean[] visited, int[] colors, int node, int color) {
        visited[node] = true;
        colors[node] = color;
        for (int nei = 0; nei < graph.length; nei++) {
            if (graph[node][nei] == 1 && !visited[nei]) {
                dfs(graph, visited, colors, nei, color);
            }
        }
    }
}