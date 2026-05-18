import java.util.*;

class Solution {
    int index = 0;

    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression);

        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);

        return ans;
    }

    private Set<String> parse(String s) {
        Set<String> curr = new HashSet<>();
        curr.add("");

        Set<String> result = new HashSet<>();

        while (index < s.length() && s.charAt(index) != '}') {
            char ch = s.charAt(index);

            if (ch == ',') {
                result.addAll(curr);
                curr = new HashSet<>();
                curr.add("");
                index++;
            } else if (ch == '{') {
                index++;

                Set<String> next = parse(s);

                index++;

                curr = combine(curr, next);
            } else {
                Set<String> next = new HashSet<>();
                next.add(String.valueOf(ch));

                curr = combine(curr, next);

                index++;
            }
        }

        result.addAll(curr);

        return result;
    }

    private Set<String> combine(Set<String> a, Set<String> b) {
        Set<String> result = new HashSet<>();

        for (String s1 : a) {
            for (String s2 : b) {
                result.add(s1 + s2);
            }
        }

        return result;
    }
}