import java.util.*;

class Solution {
    public int rectangleArea(int[][] rectangles) {
        int MOD = 1_000_000_007;
        List<int[]> events = new ArrayList<>();
        Set<Integer> ys = new HashSet<>();

        for (int[] r : rectangles) {
            events.add(new int[]{r[0], r[1], r[3], 1});
            events.add(new int[]{r[2], r[1], r[3], -1});
            ys.add(r[1]);
            ys.add(r[3]);
        }

        Collections.sort(events, (a, b) -> a[0] - b[0]);

        List<Integer> yList = new ArrayList<>(ys);
        Collections.sort(yList);
        Map<Integer, Integer> yIndex = new HashMap<>();
        for (int i = 0; i < yList.size(); i++) yIndex.put(yList.get(i), i);

        int[] count = new int[yList.size()];
        long[] seg = new long[yList.size()];

        long prevX = 0, area = 0;

        for (int[] e : events) {
            long x = e[0];
            long cover = 0;

            for (int i = 0; i < yList.size() - 1; i++) {
                if (count[i] > 0) {
                    cover += yList.get(i + 1) - yList.get(i);
                }
            }

            area = (area + cover * (x - prevX)) % MOD;
            prevX = x;

            int y1 = yIndex.get(e[1]);
            int y2 = yIndex.get(e[2]);

            for (int i = y1; i < y2; i++) {
                count[i] += e[3];
            }
        }

        return (int) area;
    }
}