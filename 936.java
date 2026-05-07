class Solution {
    public int[][] movesToStamp(String stamp, String target) {
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();

        java.util.List<Integer> result = new java.util.ArrayList<>();
        boolean[] visited = new boolean[target.length()];
        int stars = 0;

        while (stars < target.length()) {
            boolean replaced = false;

            for (int i = 0; i <= target.length() - stamp.length(); i++) {
                if (!visited[i] && canReplace(t, i, s)) {
                    stars += doReplace(t, i, stamp.length());
                    visited[i] = true;
                    replaced = true;
                    result.add(i);

                    if (stars == target.length()) {
                        break;
                    }
                }
            }

            if (!replaced) {
                return new int[0];
            }
        }

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(result.size() - 1 - i);
        }

        return ans;
    }

    private boolean canReplace(char[] target, int pos, char[] stamp) {
        for (int i = 0; i < stamp.length; i++) {
            if (target[i + pos] != '*' && target[i + pos] != stamp[i]) {
                return false;
            }
        }

        return true;
    }

    private int doReplace(char[] target, int pos, int len) {
        int count = 0;

        for (int i = 0; i < len; i++) {
            if (target[i + pos] != '*') {
                target[i + pos] = '*';
                count++;
            }
        }

        return count;
    }
}