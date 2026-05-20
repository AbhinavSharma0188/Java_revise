import java.util.*;

class Solution {

    public int[] shortestAlternatingPaths(
        int n,
        int[][] redEdges,
        int[][] blueEdges
    ) {

        // Graph:
        // color 0 = red
        // color 1 = blue
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : redEdges) {
            graph[edge[0]].add(new int[]{edge[1], 0});
        }

        for (int[] edge : blueEdges) {
            graph[edge[0]].add(new int[]{edge[1], 1});
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        // visited[node][color]
        boolean[][] visited = new boolean[n][2];

        Queue<int[]> queue = new LinkedList<>();

        // Start with both colors
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});

        visited[0][0] = true;
        visited[0][1] = true;

        int steps = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] curr = queue.poll();

                int node = curr[0];
                int color = curr[1];

                if (ans[node] == -1) {
                    ans[node] = steps;
                }

                for (int[] next : graph[node]) {

                    int nextNode = next[0];
                    int nextColor = next[1];

                    // Alternate colors
                    if (
                        nextColor != color
                        && !visited[nextNode][nextColor]
                    ) {

                        visited[nextNode][nextColor] = true;

                        queue.offer(
                            new int[]{
                                nextNode,
                                nextColor
                            }
                        );
                    }
                }
            }

            steps++;
        }

        return ans;
    }
}