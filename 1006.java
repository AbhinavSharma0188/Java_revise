class Solution {
    public int clumsy(int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        n--;

        int index = 0;

        while (n > 0) {
            if (index % 4 == 0) {
                stack.push(stack.pop() * n);
            } else if (index % 4 == 1) {
                stack.push(stack.pop() / n);
            } else if (index % 4 == 2) {
                stack.push(n);
            } else {
                stack.push(-n);
            }

            index++;
            n--;
        }

        int result = 0;

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}