import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] freq = new int[26];
        for (char c : p.toCharArray()) {
            freq[c - 'a']++;
        }

        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            if (freq[s.charAt(right) - 'a']-- > 0) {
                count--;
            }
            right++;

            if (count == 0) {
                res.add(left);
            }

            if (right - left == p.length()) {
                if (freq[s.charAt(left) - 'a']++ >= 0) {
                    count++;
                }
                left++;
            }
        }

        return res;
    }
}