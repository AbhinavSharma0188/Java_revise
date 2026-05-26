class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> count = new Stack<>();

        for (char ch : s.toCharArray()) {
            sb.append(ch);

            int last = sb.length() - 1;

            if (last > 0 && sb.charAt(last) == sb.charAt(last - 1)) {
                count.push(count.pop() + 1);
            } else {
                count.push(1);
            }

            if (count.peek() == k) {
                sb.delete(sb.length() - k, sb.length());
                count.pop();
            }
        }

        return sb.toString();
    }
}