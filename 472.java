import java.util.*;

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (canForm(word, set)) {
                result.add(word);
            }
            set.add(word);
        }
        return result;
    }

    private boolean canForm(String word, Set<String> set) {
        if (set.isEmpty()) return false;
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) continue;
                if (set.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}