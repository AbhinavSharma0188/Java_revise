class Solution {
    public String longestDupSubstring(String s) {
        int n = s.length();

        int left = 1;
        int right = n - 1;

        int start = -1;
        int maxLen = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int idx = search(s, mid);

            if (idx != -1) {
                start = idx;
                maxLen = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return start == -1 ? "" : s.substring(start, start + maxLen);
    }

    private int search(String s, int len) {
        long mod = (1L << 31) - 1;
        long base = 256;

        long hash = 0;
        long power = 1;

        for (int i = 0; i < len; i++) {
            hash = (hash * base + s.charAt(i)) % mod;

            if (i > 0) {
                power = (power * base) % mod;
            }
        }

        Set<Long> seen = new HashSet<>();
        seen.add(hash);

        for (int i = len; i < s.length(); i++) {
            hash = (hash - s.charAt(i - len) * power % mod + mod) % mod;
            hash = (hash * base + s.charAt(i)) % mod;

            if (seen.contains(hash)) {
                return i - len + 1;
            }

            seen.add(hash);
        }

        return -1;
    }
}