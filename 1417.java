class Solution {
    public String reformat(String s) {
        StringBuilder letters = new StringBuilder();
        StringBuilder digits = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                digits.append(ch);
            } else {
                letters.append(ch);
            }
        }

        if (Math.abs(letters.length() - digits.length()) > 1) {
            return "";
        }

        StringBuilder ans = new StringBuilder();
        int i = 0, j = 0;

        boolean letterFirst = letters.length() >= digits.length();

        while (i < letters.length() || j < digits.length()) {
            if (letterFirst && i < letters.length()) {
                ans.append(letters.charAt(i++));
            }
            if (j < digits.length()) {
                ans.append(digits.charAt(j++));
            }
            if (!letterFirst && i < letters.length()) {
                ans.append(letters.charAt(i++));
            }
        }

        return ans.toString();
    }
}