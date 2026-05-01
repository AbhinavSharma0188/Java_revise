class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        java.util.List<int[]>[] graph = new java.util.ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new java.util.ArrayList<>();
        
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }
        
        java.util.PriorityQueue<int[]> pq = new java.util.PriorityQueue<>((a, b) -> b[1] - a[1]);
        pq.offer(new int[]{0, maxMoves});
        
        boolean[] visited = new boolean[n];
        int res = 0;
        
        java.util.Map<Long, Integer> used = new java.util.HashMap<>();
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], moves = cur[1];
            
            if (visited[node]) continue;
            visited[node] = true;
            res++;
            
            for (int[] nei : graph[node]) {
                int next = nei[0], cnt = nei[1];
                long key = ((long) node << 32) | next;
                used.put(key, Math.min(cnt, moves));
                
                if (moves > cnt && !visited[next]) {
                    pq.offer(new int[]{next, moves - cnt - 1});
                }
            }
        }
        
        for (int[] e : edges) {
            long key1 = ((long) e[0] << 32) | e[1];
            long key2 = ((long) e[1] << 32) | e[0];
            int a = used.getOrDefault(key1, 0);
            int b = used.getOrDefault(key2, 0);
            res += Math.min(e[2], a + b);
        }
        
        return res;
    }
}