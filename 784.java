import java.util.*;

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s.toCharArray(), 0, res);
        return res;
    }
    
    private void backtrack(char[] arr, int i, List<String> res) {
        if (i == arr.length) {
            res.add(new String(arr));
            return;
        }
        
        if (Character.isLetter(arr[i])) {
            char original = arr[i];
            
            arr[i] = Character.toLowerCase(original);
            backtrack(arr, i + 1, res);
            
            arr[i] = Character.toUpperCase(original);
            backtrack(arr, i + 1, res);
            
            arr[i] = original;
        } else {
            backtrack(arr, i + 1, res);
        }
    }
}