import java.util.*;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        backtrack(res, num, target, 0, 0, 0, "");
        return res;
    }
    
    private void backtrack(List<String> res, String num, int target, int index, long value, long prev, String path) {
        if (index == num.length()) {
            if (value == target) res.add(path);
            return;
        }
        
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') break;
            long curr = Long.parseLong(num.substring(index, i + 1));
            
            if (index == 0) {
                backtrack(res, num, target, i + 1, curr, curr, path + curr);
            } else {
                backtrack(res, num, target, i + 1, value + curr, curr, path + "+" + curr);
                backtrack(res, num, target, i + 1, value - curr, -curr, path + "-" + curr);
                backtrack(res, num, target, i + 1, value - prev + prev * curr, prev * curr, path + "*" + curr);
            }
        }
    }
}