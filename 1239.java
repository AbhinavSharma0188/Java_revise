import java.util.*;

class Solution {

    int max = 0;

    public int maxLength(List<String> arr) {
        backtrack(arr, "", 0);
        return max;
    }

    private void backtrack(List<String> arr, String curr, int idx) {

        if (!isUnique(curr)) {
            return;
        }

        max = Math.max(max, curr.length());

        for (int i = idx; i < arr.size(); i++) {
            backtrack(arr, curr + arr.get(i), i + 1);
        }
    }

    private boolean isUnique(String s) {

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {

            if (freq[ch - 'a'] > 0) {
                return false;
            }

            freq[ch - 'a']++;
        }

        return true;
    }
}