class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(helper(nums, firstLen, secondLen),
                        helper(nums, secondLen, firstLen));
    }

    private int helper(int[] nums, int L, int M) {
        int n = nums.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int maxL = 0;
        int result = 0;

        for (int i = L + M; i <= n; i++) {
            maxL = Math.max(maxL, prefix[i - M] - prefix[i - M - L]);

            result = Math.max(result,
                    maxL + (prefix[i] - prefix[i - M]));
        }

        return result;
    }
}