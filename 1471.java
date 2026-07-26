class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int median = arr[(n - 1) / 2];
        int[] ans = new int[k];
        int left = 0, right = n - 1, index = 0;

        while (index < k) {
            if (Math.abs(arr[right] - median) >= Math.abs(arr[left] - median)) {
                ans[index++] = arr[right--];
            } else {
                ans[index++] = arr[left++];
            }
        }

        return ans;
    }
}