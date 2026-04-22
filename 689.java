class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n - k + 1];

        int window = 0;
        for (int i = 0; i < n; i++) {
            window += nums[i];
            if (i >= k) window -= nums[i - k];
            if (i >= k - 1) sum[i - k + 1] = window;
        }

        int[] left = new int[sum.length];
        int best = 0;
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] > sum[best]) best = i;
            left[i] = best;
        }

        int[] right = new int[sum.length];
        best = sum.length - 1;
        for (int i = sum.length - 1; i >= 0; i--) {
            if (sum[i] >= sum[best]) best = i;
            right[i] = best;
        }

        int[] res = new int[3];
        int maxSum = 0;

        for (int j = k; j < sum.length - k; j++) {
            int i = left[j - k];
            int l = right[j + k];

            int total = sum[i] + sum[j] + sum[l];
            if (total > maxSum) {
                maxSum = total;
                res[0] = i;
                res[1] = j;
                res[2] = l;
            }
        }

        return res;
    }
}