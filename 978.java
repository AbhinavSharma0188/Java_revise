class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;

        if (n == 1) {
            return 1;
        }

        int max = 1;
        int left = 0;

        for (int right = 1; right < n; right++) {
            int cmp = Integer.compare(arr[right - 1], arr[right]);

            if (cmp == 0) {
                left = right;
            } else if (right == n - 1 || 
                      cmp * Integer.compare(arr[right], arr[right + 1]) != -1) {
                max = Math.max(max, right - left + 1);
                left = right;
            }
        }

        return max;
    }
}