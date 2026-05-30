class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        int[] top = new int[n];
        int[] bottom = new int[n];

        for (int i = 0; i < n; i++) {
            if (colsum[i] == 2) {
                top[i] = 1;
                bottom[i] = 1;
                upper--;
                lower--;
            }
        }

        for (int i = 0; i < n; i++) {
            if (colsum[i] == 1) {
                if (upper > lower) {
                    top[i] = 1;
                    upper--;
                } else {
                    bottom[i] = 1;
                    lower--;
                }
            }
        }

        if (upper != 0 || lower != 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        List<Integer> row2 = new ArrayList<>();

        for (int x : top) row1.add(x);
        for (int x : bottom) row2.add(x);

        result.add(row1);
        result.add(row2);

        return result;
    }
}