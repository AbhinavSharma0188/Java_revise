class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        
        for (int[] t : times) {
            graph[t[0]].add(new int[]{t[1], t[2]});
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], time = curr[1];
            
            if (time > dist[node]) continue;
            
            for (int[] nei : graph[node]) {
                int next = nei[0], wt = nei[1];
                if (dist[next] > time + wt) {
                    dist[next] = time + wt;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }
        
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        
        return max;
    }
}