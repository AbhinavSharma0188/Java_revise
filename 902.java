class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = String.valueOf(n);
        int len = s.length();
        int d = digits.length;

        int res = 0;

        for (int i = 1; i < len; i++) {
            res += Math.pow(d, i);
        }

        for (int i = 0; i < len; i++) {
            boolean hasSame = false;
            for (String digit : digits) {
                if (digit.charAt(0) < s.charAt(i)) {
                    res += Math.pow(d, len - i - 1);
                } else if (digit.charAt(0) == s.charAt(i)) {
                    hasSame = true;
                    break;
                }
            }
            if (!hasSame) return res;
        }

        return res + 1;
    }
}