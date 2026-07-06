class Solution {
    private int count = 0;
    private String answer = "";

    public String getHappyString(int n, int k) {
        dfs(new StringBuilder(), n, k);
        return answer;
    }

    private void dfs(StringBuilder sb, int n, int k) {
        if (!answer.isEmpty()) return;

        if (sb.length() == n) {
            count++;
            if (count == k) {
                answer = sb.toString();
            }
            return;
        }

        char[] chars = {'a', 'b', 'c'};

        for (char ch : chars) {
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != ch) {
                sb.append(ch);
                dfs(sb, n, k);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}