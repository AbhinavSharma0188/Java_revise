import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                map.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        if (!map.containsKey(source) || !map.containsKey(target)) return -1;

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedBuses = new HashSet<>();

        q.offer(source);
        visitedStops.add(source);

        int buses = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            buses++;

            for (int i = 0; i < size; i++) {
                int stop = q.poll();

                for (int bus : map.get(stop)) {
                    if (visitedBuses.contains(bus)) continue;
                    visitedBuses.add(bus);

                    for (int nextStop : routes[bus]) {
                        if (nextStop == target) return buses;
                        if (!visitedStops.contains(nextStop)) {
                            visitedStops.add(nextStop);
                            q.offer(nextStop);
                        }
                    }
                }
            }
        }

        return -1;
    }
}