class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == ',' || ch == '(') {
                continue;
            }

            if (ch != ')') {
                stack.push(ch);
            } else {
                int t = 0;
                int f = 0;

                while (stack.peek() != '!' && stack.peek() != '&' && stack.peek() != '|') {
                    char curr = stack.pop();

                    if (curr == 't') {
                        t++;
                    } else if (curr == 'f') {
                        f++;
                    }
                }

                char op = stack.pop();

                if (op == '!') {
                    stack.push(f == 1 ? 't' : 'f');
                } else if (op == '&') {
                    stack.push(f == 0 ? 't' : 'f');
                } else {
                    stack.push(t > 0 ? 't' : 'f');
                }
            }
        }

        return stack.pop() == 't';
    }
}