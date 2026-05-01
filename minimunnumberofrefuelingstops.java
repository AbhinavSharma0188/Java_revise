class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>(java.util.Collections.reverseOrder());
        int fuel = startFuel, i = 0, stops = 0, n = stations.length;
        
        while (fuel < target) {
            while (i < n && stations[i][0] <= fuel) {
                pq.offer(stations[i][1]);
                i++;
            }
            if (pq.isEmpty()) return -1;
            fuel += pq.poll();
            stops++;
        }
        
        return stops;
    }
}