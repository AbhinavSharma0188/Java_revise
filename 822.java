import java.util.*;

class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> bad = new HashSet<>();

        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                bad.add(fronts[i]);
            }
        }

        int res = Integer.MAX_VALUE;

        for (int num : fronts) {
            if (!bad.contains(num)) {
                res = Math.min(res, num);
            }
        }

        for (int num : backs) {
            if (!bad.contains(num)) {
                res = Math.min(res, num);
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}