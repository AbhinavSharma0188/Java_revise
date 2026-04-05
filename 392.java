class Solution {
    public int[] isSubsequence(String s, String[] words) {
        int n = s.length();
        int[][] next = new int[n + 1][26];

        for (int i = 0; i < 26; i++) {
            next[n][i] = -1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                next[i][j] = next[i + 1][j];
            }
            next[i][s.charAt(i) - 'a'] = i + 1;
        }

        int count = 0;

        for (String word : words) {
            int index = 0;
            boolean found = true;
            for (int i = 0; i < word.length(); i++) {
                if (index > n || next[index][word.charAt(i) - 'a'] == -1) {
                    found = false;
                    break;
                }
                index = next[index][word.charAt(i) - 'a'];
            }
            if (found) count++;
        }

        return new int[]{count};
    }
}