import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> freq = new HashMap<>();
        int[] count = new int[26];
        int unique = 0;
        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            if (count[s.charAt(right) - 'a']++ == 0) {
                unique++;
            }

            if (right - left + 1 > minSize) {
                if (--count[s.charAt(left) - 'a'] == 0) {
                    unique--;
                }
                left++;
            }

            if (right - left + 1 == minSize && unique <= maxLetters) {
                String sub = s.substring(left, right + 1);
                int f = freq.getOrDefault(sub, 0) + 1;
                freq.put(sub, f);
                ans = Math.max(ans, f);
            }
        }

        return ans;
    }
}