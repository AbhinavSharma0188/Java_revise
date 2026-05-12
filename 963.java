class Solution {
    public double minAreaFreeRect(int[][] points) {
        int n = points.length;
        double minArea = Double.MAX_VALUE;

        java.util.Map<String, java.util.List<int[]>> map = new java.util.HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int midX = points[i][0] + points[j][0];
                int midY = points[i][1] + points[j][1];

                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];

                int dist = dx * dx + dy * dy;

                String key = midX + "," + midY + "," + dist;

                map.putIfAbsent(key, new java.util.ArrayList<>());
                map.get(key).add(new int[]{i, j});
            }
        }

        for (java.util.List<int[]> list : map.values()) {
            int size = list.size();

            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    int[] p1 = points[list.get(i)[0]];
                    int[] p2 = points[list.get(i)[1]];
                    int[] p3 = points[list.get(j)[0]];

                    double side1 = distance(p1, p3);
                    double side2 = distance(p2, p3);

                    minArea = Math.min(minArea, side1 * side2);
                }
            }
        }

        return minArea == Double.MAX_VALUE ? 0 : minArea;
    }

    private double distance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return Math.sqrt(dx * dx + dy * dy);
    }
}