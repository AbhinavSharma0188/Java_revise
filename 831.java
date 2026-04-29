class Solution {
    public String maskPII(String s) {
        if (s.contains("@")) {
            s = s.toLowerCase();
            int at = s.indexOf('@');
            return s.charAt(0) + "*****" + s.charAt(at - 1) + s.substring(at);
        } else {
            String digits = "";
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    digits += c;
                }
            }
            int n = digits.length();
            String local = "***-***-" + digits.substring(n - 4);
            if (n == 10) return local;
            String country = "+";
            for (int i = 0; i < n - 10; i++) {
                country += "*";
            }
            return country + "-" + local;
        }
    }
}