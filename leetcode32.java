class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                int prev = i - dp[i - 1] - 1;
                if (prev >= 0 && s.charAt(prev) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (prev > 0) dp[i] += dp[prev - 1];
                }
            }
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}