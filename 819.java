import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>();
        for (String b : banned) ban.add(b);

        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");
        String[] words = paragraph.split("\\s+");

        Map<String, Integer> map = new HashMap<>();
        String res = "";
        int max = 0;

        for (String word : words) {
            if (word.length() == 0 || ban.contains(word)) continue;

            map.put(word, map.getOrDefault(word, 0) + 1);

            if (map.get(word) > max) {
                max = map.get(word);
                res = word;
            }
        }

        return res;
    }
}