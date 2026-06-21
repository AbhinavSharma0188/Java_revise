class Solution {
    public int findTheLongestSubstring(String s) {
        int[] pos = new int[32];
        for (int i = 0; i < 32; i++) {
            pos[i] = -2;
        }

        pos[0] = -1;
        int mask = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'a')
                mask ^= 1;
            else if (c == 'e')
                mask ^= 2;
            else if (c == 'i')
                mask ^= 4;
            else if (c == 'o')
                mask ^= 8;
            else if (c == 'u')
                mask ^= 16;

            if (pos[mask] != -2) {
                ans = Math.max(ans, i - pos[mask]);
            } else {
                pos[mask] = i;
            }
        }

        return ans;
    }
}