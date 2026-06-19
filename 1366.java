import java.util.*;

class Solution {
    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        Map<Character, int[]> map = new HashMap<>();

        for (char c : votes[0].toCharArray()) {
            map.put(c, new int[n]);
        }

        for (String vote : votes) {
            for (int i = 0; i < n; i++) {
                map.get(vote.charAt(i))[i]++;
            }
        }

        List<Character> teams = new ArrayList<>(map.keySet());

        teams.sort((a, b) -> {
            int[] ca = map.get(a);
            int[] cb = map.get(b);

            for (int i = 0; i < n; i++) {
                if (ca[i] != cb[i]) {
                    return cb[i] - ca[i];
                }
            }
            return a - b;
        });

        StringBuilder sb = new StringBuilder();
        for (char c : teams) {
            sb.append(c);
        }

        return sb.toString();
    }
}