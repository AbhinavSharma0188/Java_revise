import java.util.*;

class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] r : richer) {
            graph.get(r[1]).add(r[0]);
        }

        int[] res = new int[n];
        Arrays.fill(res, -1);

        for (int i = 0; i < n; i++) {
            dfs(i, graph, quiet, res);
        }

        return res;
    }

    private int dfs(int i, List<List<Integer>> graph, int[] quiet, int[] res) {
        if (res[i] != -1) return res[i];
        res[i] = i;

        for (int nei : graph.get(i)) {
            int cand = dfs(nei, graph, quiet, res);
            if (quiet[cand] < quiet[res[i]]) {
                res[i] = cand;
            }
        }

        return res[i];
    }
}