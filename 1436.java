class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> starts = new HashSet<>();

        // Store all starting cities
        for (List<String> path : paths) {
            starts.add(path.get(0));
        }

        // Find the city that never appears as a starting city
        for (List<String> path : paths) {
            String destination = path.get(1);
            if (!starts.contains(destination)) {
                return destination;
            }
        }

        return "";
    }
}