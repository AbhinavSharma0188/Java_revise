class Solution {
    public String fractionAddition(String expression) {
        int num = 0, den = 1;
        int i = 0, n = expression.length();
        
        while (i < n) {
            int sign = 1;
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                sign = expression.charAt(i) == '-' ? -1 : 1;
                i++;
            }
            
            int n1 = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                n1 = n1 * 10 + (expression.charAt(i) - '0');
                i++;
            }
            
            i++;
            
            int d1 = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                d1 = d1 * 10 + (expression.charAt(i) - '0');
                i++;
            }
            
            n1 *= sign;
            
            num = num * d1 + n1 * den;
            den = den * d1;
            
            int g = gcd(Math.abs(num), Math.abs(den));
            num /= g;
            den /= g;
        }
        
        return num + "/" + den;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}