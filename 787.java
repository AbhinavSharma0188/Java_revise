import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        
        for (int[] f : flights) {
            map.computeIfAbsent(f[0], x -> new ArrayList<>()).add(new int[]{f[1], f[2]});
        }
        
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0, 0});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0], price = cur[1], stops = cur[2];
            
            if (stops > k) continue;
            
            if (!map.containsKey(node)) continue;
            
            for (int[] nei : map.get(node)) {
                int next = nei[0], newPrice = price + nei[1];
                
                if (newPrice < cost[next]) {
                    cost[next] = newPrice;
                    q.offer(new int[]{next, newPrice, stops + 1});
                }
            }
        }
        
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}