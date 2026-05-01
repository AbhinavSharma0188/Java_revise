class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        java.util.List<Integer>[] graph = new java.util.ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new java.util.ArrayList<>();
        
        for (int[] d : dislikes) {
            graph[d[0]].add(d[1]);
            graph[d[1]].add(d[0]);
        }
        
        int[] color = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            if (color[i] != 0) continue;
            java.util.Queue<Integer> q = new java.util.LinkedList<>();
            q.offer(i);
            color[i] = 1;
            
            while (!q.isEmpty()) {
                int node = q.poll();
                for (int nei : graph[node]) {
                    if (color[nei] == 0) {
                        color[nei] = -color[node];
                        q.offer(nei);
                    } else if (color[nei] == color[node]) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}