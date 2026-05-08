class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;
        long[] last = new long[26];
        long total = 0;

        for (char c : s.toCharArray()) {
            long newTotal = (2 * total + 1 - last[c - 'a'] + mod) % mod;
            last[c - 'a'] = (total + 1) % mod;
            total = newTotal;
        }

        return (int) total;
    }
}