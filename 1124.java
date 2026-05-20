import java.util.*;

class Solution {

    public int longestWPI(int[] hours) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int score = 0;
        int maxLen = 0;

        for (int i = 0; i < hours.length; i++) {

            // Tiring day = +1
            // Non-tiring day = -1
            if (hours[i] > 8) {
                score++;
            } else {
                score--;
            }

            // Entire interval is valid
            if (score > 0) {
                maxLen = i + 1;
            } else {

                // Store first occurrence
                if (!map.containsKey(score)) {
                    map.put(score, i);
                }

                // Check if score - 1 exists
                if (map.containsKey(score - 1)) {
                    maxLen = Math.max(
                        maxLen,
                        i - map.get(score - 1)
                    );
                }
            }
        }

        return maxLen;
    }
}