class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length, res = 0, i = 1;

        while (i < n - 1) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int l = i, r = i;

                while (l > 0 && arr[l - 1] < arr[l]) l--;
                while (r < n - 1 && arr[r] > arr[r + 1]) r++;

                res = Math.max(res, r - l + 1);
                i = r;
            } else {
                i++;
            }
        }

        return res;
    }
}