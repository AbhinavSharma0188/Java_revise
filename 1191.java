class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int mod = 1000000007;

        long maxKadane = kadane(arr);

        if (k == 1) {
            return (int)(maxKadane % mod);
        }

        long sum = 0;

        for (int num : arr) {
            sum += num;
        }

        long doubleKadane = kadaneTwo(arr);

        if (sum > 0) {
            return (int)((doubleKadane + (k - 2) * sum) % mod);
        }

        return (int)(doubleKadane % mod);
    }

    private long kadane(int[] arr) {
        long maxSoFar = 0;
        long curr = 0;

        for (int num : arr) {
            curr = Math.max(0, curr + num);
            maxSoFar = Math.max(maxSoFar, curr);
        }

        return maxSoFar;
    }

    private long kadaneTwo(int[] arr) {
        long maxSoFar = 0;
        long curr = 0;

        for (int i = 0; i < 2; i++) {
            for (int num : arr) {
                curr = Math.max(0, curr + num);
                maxSoFar = Math.max(maxSoFar, curr);
            }
        }

        return maxSoFar;
    }
}