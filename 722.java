import java.util.*;

class Solution {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean block = false;

        for (String line : source) {
            int i = 0;
            char[] arr = line.toCharArray();

            if (!block) sb.setLength(0);

            while (i < arr.length) {
                if (!block && i + 1 < arr.length && arr[i] == '/' && arr[i + 1] == '*') {
                    block = true;
                    i += 2;
                } else if (block && i + 1 < arr.length && arr[i] == '*' && arr[i + 1] == '/') {
                    block = false;
                    i += 2;
                } else if (!block && i + 1 < arr.length && arr[i] == '/' && arr[i + 1] == '/') {
                    break;
                } else if (!block) {
                    sb.append(arr[i]);
                    i++;
                } else {
                    i++;
                }
            }

            if (!block && sb.length() > 0) {
                res.add(sb.toString());
            }
        }

        return res;
    }
}