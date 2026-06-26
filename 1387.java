class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
        memo.put(1, 0);

        List<int[]> list = new ArrayList<>();

        for (int i = lo; i <= hi; i++) {
            list.add(new int[]{power(i), i});
        }

        Collections.sort(list, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        return list.get(k - 1)[1];
    }

    private int power(int x) {
        if (memo.containsKey(x)) return memo.get(x);

        int res;
        if (x % 2 == 0) {
            res = 1 + power(x / 2);
        } else {
            res = 1 + power(3 * x + 1);
        }

        memo.put(x, res);
        return res;
    }
}