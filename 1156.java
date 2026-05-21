class Solution {

    public int maxRepOpt1(String text) {

        int[] freq = new int[26];

        for (char ch : text.toCharArray()) {
            freq[ch - 'a']++;
        }

        int ans = 0;

        for (char c = 'a'; c <= 'z'; c++) {

            int left = 0;
            int diff = 0;

            for (int right = 0; right < text.length(); right++) {

                if (text.charAt(right) != c) {
                    diff++;
                }

                while (diff > 1) {

                    if (text.charAt(left) != c) {
                        diff--;
                    }

                    left++;
                }

                ans = Math.max(
                    ans,
                    Math.min(right - left + 1, freq[c - 'a'])
                );
            }
        }

        return ans;
    }
}