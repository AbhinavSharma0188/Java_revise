class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);

        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(arr1[0], 0);

        int idx = firstGreater(arr2, -1);
        if (idx < arr2.length) {
            dp.put(arr2[idx], 1);
        }

        for (int i = 1; i < arr1.length; i++) {
            Map<Integer, Integer> next = new HashMap<>();

            for (int prev : dp.keySet()) {
                int ops = dp.get(prev);

                if (arr1[i] > prev) {
                    next.put(arr1[i],
                        Math.min(next.getOrDefault(arr1[i], Integer.MAX_VALUE), ops));
                }

                int j = firstGreater(arr2, prev);

                if (j < arr2.length) {
                    next.put(arr2[j],
                        Math.min(next.getOrDefault(arr2[j], Integer.MAX_VALUE), ops + 1));
                }
            }

            dp = next;

            if (dp.isEmpty()) {
                return -1;
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int val : dp.values()) {
            ans = Math.min(ans, val);
        }

        return ans;
    }

    private int firstGreater(int[] arr, int target) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}