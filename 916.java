class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];

        for (String b : words2) {
            int[] freq = new int[26];
            for (char c : b.toCharArray()) {
                freq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }

        List<String> res = new ArrayList<>();

        for (String a : words1) {
            int[] freq = new int[26];
            for (char c : a.toCharArray()) {
                freq[c - 'a']++;
            }

            boolean valid = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] < maxFreq[i]) {
                    valid = false;
                    break;
                }
            }

            if (valid) res.add(a);
        }

        return res;
    }
}