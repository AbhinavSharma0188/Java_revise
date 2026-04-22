import java.util.*;

class Solution {
    public int minStickers(String[] stickers, String target) {
        int n = stickers.length;
        int[][] count = new int[n][26];

        for (int i = 0; i < n; i++) {
            for (char c : stickers[i].toCharArray()) {
                count[i][c - 'a']++;
            }
        }

        Map<String, Integer> memo = new HashMap<>();
        memo.put("", 0);

        int res = dfs(memo, count, target);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dfs(Map<String, Integer> memo, int[][] count, String target) {
        if (memo.containsKey(target)) return memo.get(target);

        int[] targetCount = new int[26];
        for (char c : target.toCharArray()) {
            targetCount[c - 'a']++;
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < count.length; i++) {
            if (count[i][target.charAt(0) - 'a'] == 0) continue;

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < 26; j++) {
                if (targetCount[j] > 0) {
                    int remain = targetCount[j] - count[i][j];
                    for (int k = 0; k < remain; k++) {
                        sb.append((char) (j + 'a'));
                    }
                }
            }

            String next = sb.toString();
            int temp = dfs(memo, count, next);

            if (temp != Integer.MAX_VALUE) {
                ans = Math.min(ans, 1 + temp);
            }
        }

        memo.put(target, ans);
        return ans;
    }
}