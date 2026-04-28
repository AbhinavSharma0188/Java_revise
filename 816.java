import java.util.*;

class Solution {
    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        s = s.substring(1, s.length() - 1);

        for (int i = 1; i < s.length(); i++) {
            List<String> left = generate(s.substring(0, i));
            List<String> right = generate(s.substring(i));

            for (String l : left) {
                for (String r : right) {
                    result.add("(" + l + ", " + r + ")");
                }
            }
        }

        return result;
    }

    private List<String> generate(String s) {
        List<String> res = new ArrayList<>();

        if (s.length() == 1 || s.charAt(0) != '0') {
            res.add(s);
        }

        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);

            if ((left.length() > 1 && left.charAt(0) == '0')) continue;
            if (right.charAt(right.length() - 1) == '0') continue;

            res.add(left + "." + right);
        }

        return res;
    }
}