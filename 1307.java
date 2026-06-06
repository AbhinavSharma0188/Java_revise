import java.util.Arrays;

class Solution {
    public boolean isSolvable(String[] words, String result) {
        int[] map = new int[26];
        Arrays.fill(map, -1);
        boolean[] used = new boolean[10];
        boolean[] leading = new boolean[26];

        for (String word : words) {
            if (word.length() > 1) {
                leading[word.charAt(0) - 'A'] = true;
            }
        }

        if (result.length() > 1) {
            leading[result.charAt(0) - 'A'] = true;
        }

        return dfs(words, result, 0, 0, 0, map, used, leading);
    }

    private boolean dfs(String[] words, String result, int col, int row, int sum,
                        int[] map, boolean[] used, boolean[] leading) {
        if (col == result.length()) {
            return sum == 0;
        }

        if (row < words.length) {
            if (col >= words[row].length()) {
                return dfs(words, result, col, row + 1, sum, map, used, leading);
            }

            int ch = words[row].charAt(words[row].length() - 1 - col) - 'A';

            if (map[ch] != -1) {
                return dfs(words, result, col, row + 1, sum + map[ch], map, used, leading);
            }

            for (int d = 0; d <= 9; d++) {
                if (used[d] || (d == 0 && leading[ch])) {
                    continue;
                }

                used[d] = true;
                map[ch] = d;

                if (dfs(words, result, col, row + 1, sum + d, map, used, leading)) {
                    return true;
                }

                used[d] = false;
                map[ch] = -1;
            }

            return false;
        }

        int ch = result.charAt(result.length() - 1 - col) - 'A';
        int digit = sum % 10;
        int carry = sum / 10;

        if (map[ch] != -1) {
            if (map[ch] != digit) {
                return false;
            }
            return dfs(words, result, col + 1, 0, carry, map, used, leading);
        }

        if (used[digit] || (digit == 0 && leading[ch])) {
            return false;
        }

        used[digit] = true;
        map[ch] = digit;

        if (dfs(words, result, col + 1, 0, carry, map, used, leading)) {
            return true;
        }

        used[digit] = false;
        map[ch] = -1;

        return false;
    }
}