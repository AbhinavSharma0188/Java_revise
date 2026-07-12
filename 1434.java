class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();

        // hat -> people who like it
        List<Integer>[] people = new ArrayList[41];
        for (int i = 1; i <= 40; i++) {
            people[i] = new ArrayList<>();
        }

        for (int person = 0; person < n; person++) {
            for (int hat : hats.get(person)) {
                people[hat].add(person);
            }
        }

        int size = 1 << n;
        long[] dp = new long[size];
        dp[0] = 1;

        for (int hat = 1; hat <= 40; hat++) {
            long[] next = dp.clone();

            for (int mask = 0; mask < size; mask++) {
                if (dp[mask] == 0) continue;

                for (int person : people[hat]) {
                    if ((mask & (1 << person)) == 0) {
                        int newMask = mask | (1 << person);
                        next[newMask] = (next[newMask] + dp[mask]) % MOD;
                    }
                }
            }

            dp = next;
        }

        return (int) dp[size - 1];
    }
}