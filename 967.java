class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        java.util.List<Integer> result = new java.util.ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            dfs(n - 1, k, i, result);
        }

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    private void dfs(int n, int k, int num, java.util.List<Integer> result) {
        if (n == 0) {
            result.add(num);
            return;
        }

        int lastDigit = num % 10;

        if (lastDigit + k < 10) {
            dfs(n - 1, k, num * 10 + lastDigit + k, result);
        }

        if (k != 0 && lastDigit - k >= 0) {
            dfs(n - 1, k, num * 10 + lastDigit - k, result);
        }
    }
}