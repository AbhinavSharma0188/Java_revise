class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        String current = "";
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                strStack.push(current);
                current = "";
                k = 0;
            } else if (ch == ']') {
                int repeat = countStack.pop();
                StringBuilder temp = new StringBuilder(strStack.pop());
                for (int i = 0; i < repeat; i++) {
                    temp.append(current);
                }
                current = temp.toString();
            } else {
                current += ch;
            }
        }

        return current;
    }
}