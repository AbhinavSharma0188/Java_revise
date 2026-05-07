class Solution {
    public int[] beautifulArray(int n) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        result.add(1);

        while (result.size() < n) {
            java.util.List<Integer> temp = new java.util.ArrayList<>();

            for (int num : result) {
                if (num * 2 - 1 <= n) {
                    temp.add(num * 2 - 1);
                }
            }

            for (int num : result) {
                if (num * 2 <= n) {
                    temp.add(num * 2);
                }
            }

            result = temp;
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}