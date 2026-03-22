class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack[++top] = c;
            } else {
                if (top == -1) return false;
                char t = stack[top--];
                if ((c == ')' && t != '(') || (c == '}' && t != '{') || (c == ']' && t != '[')) {
                    return false;
                }
            }
        }
        
        return top == -1;
    }
}