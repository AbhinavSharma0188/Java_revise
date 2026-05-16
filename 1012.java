class Solution {
    public int numDupDigitsAtMostN(int n) {
        return n - countUnique(n);
    }

    private int countUnique(int n) {
        List<Integer> digits = new ArrayList<>();

        while (n > 0) {
            digits.add(n % 10);
            n /= 10;
        }

        int len = digits.size();
        int count = 0;

        for (int i = 1; i < len; i++) {
            count += 9 * perm(9, i - 1);
        }

        boolean[] used = new boolean[10];

        for (int i = len - 1; i >= 0; i--) {
            int d = digits.get(i);

            for (int j = (i == len - 1 ? 1 : 0); j < d; j++) {
                if (!used[j]) {
                    count += perm(10 - (len - i), i);
                }
            }

            if (used[d]) {
                return count;
            }

            used[d] = true;
        }

        return count + 1;
    }

    private int perm(int m, int n) {
        int ans = 1;

        for (int i = 0; i < n; i++) {
            ans *= (m - i);
        }

        return ans;
    }
}