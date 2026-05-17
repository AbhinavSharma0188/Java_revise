class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] path : paths) {
            int u = path[0] - 1;
            int v = path[1] - 1;

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            boolean[] used = new boolean[5];

            for (int neighbor : graph[i]) {
                used[result[neighbor]] = true;
            }

            for (int color = 1; color <= 4; color++) {
                if (!used[color]) {
                    result[i] = color;
                    break;
                }
            }
        }

        return result;
    }
}