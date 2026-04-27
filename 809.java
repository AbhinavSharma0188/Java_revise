class Solution {
    public int expressiveWords(String s, String[] words) {
        int count = 0;

        for (String w : words) {
            if (isValid(s, w)) count++;
        }

        return count;
    }

    private boolean isValid(String s, String w) {
        int i = 0, j = 0;

        while (i < s.length() && j < w.length()) {
            if (s.charAt(i) != w.charAt(j)) return false;

            int iStart = i;
            while (i < s.length() && s.charAt(i) == s.charAt(iStart)) i++;
            int len1 = i - iStart;

            int jStart = j;
            while (j < w.length() && w.charAt(j) == w.charAt(jStart)) j++;
            int len2 = j - jStart;

            if (len1 < 3 && len1 != len2) return false;
            if (len1 >= 3 && len2 > len1) return false;
        }

        return i == s.length() && j == w.length();
    }
}