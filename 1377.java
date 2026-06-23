class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        java.util.List<Integer>[] graph = new java.util.ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new java.util.ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        java.util.Queue<Double> probQueue = new java.util.LinkedList<>();
        
        queue.offer(new int[]{1, 0});
        probQueue.offer(1.0);

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            double prob = probQueue.poll();

            int node = curr[0];
            int time = curr[1];

            int children = 0;
            for (int next : graph[node]) {
                if (!visited[next]) {
                    children++;
                }
            }

            if (node == target) {
                if (time == t || (children == 0 && time < t)) {
                    return prob;
                }
                return 0.0;
            }

            if (time == t) {
                continue;
            }

            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, time + 1});
                    probQueue.offer(prob / children);
                }
            }
        }

        return 0.0;
    }
}