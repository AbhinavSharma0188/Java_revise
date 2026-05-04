import java.util.*;

class Solution {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        int[] parent = new int[n];
        int[] size = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] == 1) {
                    union(i, j, parent, size);
                }
            }
        }
        
        int[] infectedCount = new int[n];
        for (int node : initial) {
            int root = find(node, parent);
            infectedCount[root]++;
        }
        
        Arrays.sort(initial);
        int result = initial[0];
        int maxSaved = -1;
        
        for (int node : initial) {
            int root = find(node, parent);
            if (infectedCount[root] == 1) {
                if (size[root] > maxSaved) {
                    maxSaved = size[root];
                    result = node;
                }
            }
        }
        
        return result;
    }
    
    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
    
    private void union(int x, int y, int[] parent, int[] size) {
        int px = find(x, parent);
        int py = find(y, parent);
        
        if (px != py) {
            if (size[px] < size[py]) {
                parent[px] = py;
                size[py] += size[px];
            } else {
                parent[py] = px;
                size[px] += size[py];
            }
        }
    }
}