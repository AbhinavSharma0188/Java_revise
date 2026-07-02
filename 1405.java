class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder ans = new StringBuilder();

        while (true) {
            if (a >= b && a >= c) {
                if (!append(ans, 'a', 'b', 'c', new int[]{a, b, c})) break;
                int[] cnt = updateCounts(a, b, c, 'a', ans);
                a = cnt[0];
                b = cnt[1];
                c = cnt[2];
            } else if (b >= a && b >= c) {
                if (!append(ans, 'b', 'a', 'c', new int[]{b, a, c})) break;
                int[] cnt = updateCounts(a, b, c, 'b', ans);
                a = cnt[0];
                b = cnt[1];
                c = cnt[2];
            } else {
                if (!append(ans, 'c', 'a', 'b', new int[]{c, a, b})) break;
                int[] cnt = updateCounts(a, b, c, 'c', ans);
                a = cnt[0];
                b = cnt[1];
                c = cnt[2];
            }
        }

        return ans.toString();
    }

    private boolean append(StringBuilder ans, char first, char second, char third, int[] cnt) {
        if (cnt[0] == 0) return false;

        int n = ans.length();
        if (n >= 2 && ans.charAt(n - 1) == first && ans.charAt(n - 2) == first) {
            if (cnt[1] > 0) {
                ans.append(second);
            } else if (cnt[2] > 0) {
                ans.append(third);
            } else {
                return false;
            }
        } else {
            ans.append(first);
        }

        return true;
    }

    private int[] updateCounts(int a, int b, int c, char ch, StringBuilder ans) {
        char last = ans.charAt(ans.length() - 1);

        if (last == 'a') a--;
        else if (last == 'b') b--;
        else c--;

        return new int[]{a, b, c};
    }
}