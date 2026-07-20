class Solution {
    public int numPoints(int[][] darts, int r) {
        int n = darts.length;
        if (n == 1) return 1;

        double radius = r;
        int ans = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double x1 = darts[i][0], y1 = darts[i][1];
                double x2 = darts[j][0], y2 = darts[j][1];

                double dx = x2 - x1;
                double dy = y2 - y1;
                double d = Math.sqrt(dx * dx + dy * dy);

                if (d > 2 * radius) continue;

                double mx = (x1 + x2) / 2.0;
                double my = (y1 + y2) / 2.0;

                double h = Math.sqrt(radius * radius - (d / 2.0) * (d / 2.0));

                double ux = -dy / d;
                double uy = dx / d;

                double[][] centers = {
                    {mx + h * ux, my + h * uy},
                    {mx - h * ux, my - h * uy}
                };

                for (double[] c : centers) {
                    int count = 0;
                    for (int[] p : darts) {
                        double dist = Math.sqrt(
                            (p[0] - c[0]) * (p[0] - c[0]) +
                            (p[1] - c[1]) * (p[1] - c[1])
                        );
                        if (dist <= radius + 1e-7) {
                            count++;
                        }
                    }
                    ans = Math.max(ans, count);
                }
            }
        }

        return ans;
    }
}