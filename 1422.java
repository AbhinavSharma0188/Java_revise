class Solution {
    public int maxScore(String s) {
        int onesRight = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                onesRight++;
            }
        }

        int zerosLeft = 0;
        int maxScore = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zerosLeft++;
            } else {
                onesRight--;
            }

            maxScore = Math.max(maxScore, zerosLeft + onesRight);
        }

        return maxScore;
    }
}