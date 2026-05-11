class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];

        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!inOrder(words[i], words[i + 1], map)) {
                return false;
            }
        }

        return true;
    }

    private boolean inOrder(String a, String b, int[] map) {
        int len = Math.min(a.length(), b.length());

        for (int i = 0; i < len; i++) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);

            if (c1 != c2) {
                return map[c1 - 'a'] < map[c2 - 'a'];
            }
        }

        return a.length() <= b.length();
    }
}