class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];
        for (char c : letters) {
            freq[c - 'a']++;
        }
        return dfs(words, freq, score, 0);
    }

    private int dfs(String[] words, int[] freq, int[] score, int idx) {
        if (idx == words.length) {
            return 0;
        }

        int skip = dfs(words, freq, score, idx + 1);

        String word = words[idx];
        int[] used = new int[26];
        int wordScore = 0;
        boolean canTake = true;

        for (char c : word.toCharArray()) {
            int i = c - 'a';
            used[i]++;
            if (used[i] > freq[i]) {
                canTake = false;
            }
            wordScore += score[i];
        }

        int take = 0;
        if (canTake) {
            for (int i = 0; i < 26; i++) {
                freq[i] -= used[i];
            }

            take = wordScore + dfs(words, freq, score, idx + 1);

            for (int i = 0; i < 26; i++) {
                freq[i] += used[i];
            }
        }

        return Math.max(skip, take);
    }
}