class Solution {

    public int longestDecomposition(String text) {

        int n = text.length();

        String left = "";
        String right = "";

        int ans = 0;

        for (int i = 0; i < n; i++) {

            left += text.charAt(i);

            right = text.charAt(n - 1 - i) + right;

            if (left.equals(right)) {

                ans++;

                left = "";
                right = "";
            }
        }

        return ans;
    }
}