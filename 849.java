class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int prev = -1, res = 0;

        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                if (prev == -1) {
                    res = i;
                } else {
                    res = Math.max(res, (i - prev) / 2);
                }
                prev = i;
            }
        }

        res = Math.max(res, n - 1 - prev);
        return res;
    }
}