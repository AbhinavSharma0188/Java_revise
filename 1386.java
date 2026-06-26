class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            if (col >= 2 && col <= 9) {
                map.put(row, map.getOrDefault(row, 0) | (1 << (col - 2)));
            }
        }

        int ans = (n - map.size()) * 2;

        int left = 0b00001111;
        int middle = 0b00111100;
        int right = 0b11110000;

        for (int mask : map.values()) {
            boolean l = (mask & left) == 0;
            boolean m = (mask & middle) == 0;
            boolean r = (mask & right) == 0;

            if (l && r) ans += 2;
            else if (l || m || r) ans += 1;
        }

        return ans;
    }
}