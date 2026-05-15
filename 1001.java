class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> diag = new HashMap<>();
        Map<Integer, Integer> antiDiag = new HashMap<>();
        Set<Long> active = new HashSet<>();

        for (int[] lamp : lamps) {
            int r = lamp[0];
            int c = lamp[1];
            long key = ((long) r << 32) | c;

            if (active.contains(key)) continue;

            active.add(key);

            row.put(r, row.getOrDefault(r, 0) + 1);
            col.put(c, col.getOrDefault(c, 0) + 1);
            diag.put(r - c, diag.getOrDefault(r - c, 0) + 1);
            antiDiag.put(r + c, antiDiag.getOrDefault(r + c, 0) + 1);
        }

        int[] res = new int[queries.length];

        int[][] dirs = {
            {0,0},{0,1},{0,-1},{1,0},{-1,0},
            {1,1},{1,-1},{-1,1},{-1,-1}
        };

        for (int i = 0; i < queries.length; i++) {
            int r = queries[i][0];
            int c = queries[i][1];

            if (row.getOrDefault(r, 0) > 0 ||
                col.getOrDefault(c, 0) > 0 ||
                diag.getOrDefault(r - c, 0) > 0 ||
                antiDiag.getOrDefault(r + c, 0) > 0) {
                res[i] = 1;
            }

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
                    continue;
                }

                long key = ((long) nr << 32) | nc;

                if (active.remove(key)) {
                    row.put(nr, row.get(nr) - 1);
                    col.put(nc, col.get(nc) - 1);
                    diag.put(nr - nc, diag.get(nr - nc) - 1);
                    antiDiag.put(nr + nc, antiDiag.get(nr + nc) - 1);
                }
            }
        }

        return res;
    }
}