class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int inf = 1 << 30;

        int[] best = new int[n + 1];
        best[0] = inf;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        int sum = 0;
        int ans = inf;

        for (int i = 1; i <= n; i++) {
            sum += arr[i - 1];
            best[i] = best[i - 1];

            if (map.containsKey(sum - target)) {
                int j = map.get(sum - target);
                int len = i - j;
                best[i] = Math.min(best[i], len);
                ans = Math.min(ans, best[j] + len);
            }

            map.put(sum, i);
        }

        return ans > n ? -1 : ans;
    }
}