import java.util.*;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : cpdomains) {
            String[] parts = s.split(" ");
            int count = Integer.parseInt(parts[0]);
            String domain = parts[1];

            String[] frags = domain.split("\\.");

            String curr = "";
            for (int i = frags.length - 1; i >= 0; i--) {
                curr = frags[i] + (curr.isEmpty() ? "" : "." + curr);
                map.put(curr, map.getOrDefault(curr, 0) + count);
            }
        }

        List<String> res = new ArrayList<>();

        for (String key : map.keySet()) {
            res.add(map.get(key) + " " + key);
        }

        return res;
    }
}