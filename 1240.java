class Solution {

    int ans = Integer.MAX_VALUE;

    public int tilingRectangle(int n, int m) {

        if (n == m) {
            return 1;
        }

        int[] height = new int[m];

        dfs(height, n, m, 0);

        return ans;
    }

    private void dfs(int[] height, int n, int m, int count) {

        if (count >= ans) {
            return;
        }

        int minHeight = Integer.MAX_VALUE;
        int pos = -1;

        for (int i = 0; i < m; i++) {
            if (height[i] < minHeight) {
                minHeight = height[i];
                pos = i;
            }
        }

        if (minHeight == n) {
            ans = Math.min(ans, count);
            return;
        }

        int end = pos;

        while (end < m && height[end] == minHeight) {
            end++;
        }

        int width = end - pos;
        int maxSize = Math.min(n - minHeight, width);

        for (int size = maxSize; size >= 1; size--) {

            for (int i = pos; i < pos + size; i++) {
                height[i] += size;
            }

            dfs(height, n, m, count + 1);

            for (int i = pos; i < pos + size; i++) {
                height[i] -= size;
            }
        }
    }
}