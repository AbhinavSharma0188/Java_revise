import java.util.*;

class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int target = (1 << n) - 1;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][1 << n];

        for (int i = 0; i < n; i++) {
            q.offer(new int[]{i, 1 << i});
            visited[i][1 << i] = true;
        }

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                int node = curr[0];
                int mask = curr[1];

                if (mask == target) return steps;

                for (int nei : graph[node]) {
                    int nextMask = mask | (1 << nei);
                    if (!visited[nei][nextMask]) {
                        visited[nei][nextMask] = true;
                        q.offer(new int[]{nei, nextMask});
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}