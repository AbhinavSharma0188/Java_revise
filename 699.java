import java.util.*;

class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<int[]> intervals = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int maxHeight = 0;

        for (int[] p : positions) {
            int left = p[0];
            int size = p[1];
            int right = left + size;

            int height = size;

            for (int[] in : intervals) {
                int l = in[0], r = in[1], h = in[2];
                if (Math.max(left, l) < Math.min(right, r)) {
                    height = Math.max(height, h + size);
                }
            }

            intervals.add(new int[]{left, right, height});
            maxHeight = Math.max(maxHeight, height);
            result.add(maxHeight);
        }

        return result;
    }
}