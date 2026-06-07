import java.util.*;

class Solution {
    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        long mod = 1000000007L;
        long base = 31L;

        long[] hash = new long[n + 1];
        long[] power = new long[n + 1];
        power[0] = 1;

        for (int i = 0; i < n; i++) {
            hash[i + 1] = (hash[i] * base + text.charAt(i)) % mod;
            power[i + 1] = (power[i] * base) % mod;
        }

        Set<Long> set = new HashSet<>();

        for (int len = 1; len * 2 <= n; len++) {
            for (int i = 0; i + 2 * len <= n; i++) {
                long h1 = getHash(hash, power, mod, i, i + len);
                long h2 = getHash(hash, power, mod, i + len, i + 2 * len);

                if (h1 == h2) {
                    long whole = getHash(hash, power, mod, i, i + 2 * len);
                    set.add(whole);
                }
            }
        }

        return set.size();
    }

    private long getHash(long[] hash, long[] power, long mod, int l, int r) {
        return (hash[r] - hash[l] * power[r - l] % mod + mod) % mod;
    }
}