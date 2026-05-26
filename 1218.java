class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 1;

        for (int num : arr) {
            int prev = map.getOrDefault(num - difference, 0);
            int curr = prev + 1;

            map.put(num, curr);
            ans = Math.max(ans, curr);
        }

        return ans;
    }
}