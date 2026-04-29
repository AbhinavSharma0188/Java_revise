import java.util.*;

class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> res = new ArrayList<>();
        backtrack(num, res, 0);
        return res;
    }

    private boolean backtrack(String s, List<Integer> res, int index) {
        if (index == s.length() && res.size() >= 3) return true;

        long curr = 0;
        for (int i = index; i < s.length(); i++) {
            if (i > index && s.charAt(index) == '0') break;

            curr = curr * 10 + (s.charAt(i) - '0');
            if (curr > Integer.MAX_VALUE) break;

            int size = res.size();
            if (size >= 2) {
                long sum = (long) res.get(size - 1) + res.get(size - 2);
                if (curr < sum) continue;
                if (curr > sum) break;
            }

            res.add((int) curr);
            if (backtrack(s, res, i + 1)) return true;
            res.remove(res.size() - 1);
        }

        return false;
    }
}