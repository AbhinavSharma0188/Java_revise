class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        java.util.Stack<int[]> stack = new java.util.Stack<>();

        for (int i = 0; i < n; i++) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek()[0] > arr[i]) {
                count += stack.pop()[1];
            }
            stack.push(new int[]{arr[i], count});
            left[i] = count;
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek()[0] >= arr[i]) {
                count += stack.pop()[1];
            }
            stack.push(new int[]{arr[i], count});
            right[i] = count;
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + (long)arr[i] * left[i] * right[i]) % mod;
        }

        return (int)res;
    }
}