import java.util.*;

class Solution {
    int[] res, count;
    List<Set<Integer>> tree;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        res = new int[n];
        count = new int[n];
        tree = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            tree.add(new HashSet<>());
        }

        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }

        postOrder(0, -1);
        preOrder(0, -1);

        return res;
    }

    private void postOrder(int node, int parent) {
        count[node] = 1;
        for (int child : tree.get(node)) {
            if (child == parent) continue;
            postOrder(child, node);
            count[node] += count[child];
            res[node] += res[child] + count[child];
        }
    }

    private void preOrder(int node, int parent) {
        for (int child : tree.get(node)) {
            if (child == parent) continue;
            res[child] = res[node] - count[child] + (count.length - count[child]);
            preOrder(child, node);
        }
    }
}