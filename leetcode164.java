class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        if (min == max) return 0;

        int size = Math.max(1, (max - min) / (n - 1));
        int count = (max - min) / size + 1;

        int[] bucketMin = new int[count];
        int[] bucketMax = new int[count];
        boolean[] used = new boolean[count];

        for (int i = 0; i < count; i++) {
            bucketMin[i] = Integer.MAX_VALUE;
            bucketMax[i] = Integer.MIN_VALUE;
        }

        for (int x : nums) {
            int idx = (x - min) / size;
            bucketMin[idx] = Math.min(bucketMin[idx], x);
            bucketMax[idx] = Math.max(bucketMax[idx], x);
            used[idx] = true;
        }

        int prev = min, ans = 0;

        for (int i = 0; i < count; i++) {
            if (!used[i]) continue;
            ans = Math.max(ans, bucketMin[i] - prev);
            prev = bucketMax[i];
        }

        return ans;
    }
}