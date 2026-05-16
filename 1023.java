class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();

        for (String query : queries) {
            ans.add(match(query, pattern));
        }

        return ans;
    }

    private boolean match(String query, String pattern) {
        int j = 0;

        for (char ch : query.toCharArray()) {
            if (j < pattern.length() && ch == pattern.charAt(j)) {
                j++;
            } else if (Character.isUpperCase(ch)) {
                return false;
            }
        }

        return j == pattern.length();
    }
}