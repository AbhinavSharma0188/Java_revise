class Solution {
    public int countLargestGroup(int n) {
        int[] count = new int[37];

        for (int i = 1; i <= n; i++) {
            int num = i;
            int sum = 0;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            count[sum]++;
        }

        int max = 0;
        for (int c : count) {
            max = Math.max(max, c);
        }

        int ans = 0;
        for (int c : count) {
            if (c == max) {
                ans++;
            }
        }

        return ans;
    }
}