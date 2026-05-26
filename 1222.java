class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        Set<String> set = new HashSet<>();

        for (int[] q : queens) {
            set.add(q[0] + "," + q[1]);
        }

        List<List<Integer>> ans = new ArrayList<>();

        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };

        for (int[] dir : directions) {
            int r = king[0];
            int c = king[1];

            while (true) {
                r += dir[0];
                c += dir[1];

                if (r < 0 || c < 0 || r >= 8 || c >= 8) {
                    break;
                }

                if (set.contains(r + "," + c)) {
                    ans.add(Arrays.asList(r, c));
                    break;
                }
            }
        }

        return ans;
    }
}