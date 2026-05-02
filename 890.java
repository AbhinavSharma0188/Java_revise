class Solution {
    public java.util.List<String> findAndReplacePattern(String[] words, String pattern) {
        java.util.List<String> res = new java.util.ArrayList<>();
        for (String word : words) {
            if (match(word, pattern)) res.add(word);
        }
        return res;
    }

    private boolean match(String word, String pattern) {
        if (word.length() != pattern.length()) return false;

        int[] map1 = new int[256];
        int[] map2 = new int[256];

        for (int i = 0; i < word.length(); i++) {
            char c1 = word.charAt(i);
            char c2 = pattern.charAt(i);

            if (map1[c1] == 0 && map2[c2] == 0) {
                map1[c1] = c2;
                map2[c2] = c1;
            } else {
                if (map1[c1] != c2 || map2[c2] != c1) return false;
            }
        }
        return true;
    }
}