vclass Solution {
    public int numOfWays(int n) {
        long MOD = 1_000_000_007L;

        long aba = 6; // Two colors pattern (ABA)
        long abc = 6; // Three colors pattern (ABC)

        for (int i = 2; i <= n; i++) {
            long newAba = (3 * aba + 2 * abc) % MOD;
            long newAbc = (2 * aba + 2 * abc) % MOD;

            aba = newAba;
            abc = newAbc;
        }

        return (int) ((aba + abc) % MOD);
    }
