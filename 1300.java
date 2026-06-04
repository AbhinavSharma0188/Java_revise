class Solution {
    public int findBestValue(int[] arr, int target) {
        int left = 0, right = 0;

        for (int num : arr) {
            right = Math.max(right, num);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = 0;

            for (int num : arr) {
                sum += Math.min(num, mid);
            }

            if (sum < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int sum1 = 0, sum2 = 0;

        for (int num : arr) {
            sum1 += Math.min(num, left);
            sum2 += Math.min(num, left - 1);
        }

        return Math.abs(sum2 - target) <= Math.abs(sum1 - target) ? left - 1 : left;
    }
}