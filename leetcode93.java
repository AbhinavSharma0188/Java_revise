class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void backtrack(String s, int idx, int parts, StringBuilder path, List<String> res) {
        if (parts == 4 && idx == s.length()) {
            res.add(path.substring(0, path.length() - 1));
            return;
        }

        if (parts == 4 || idx == s.length()) return;

        for (int len = 1; len <= 3 && idx + len <= s.length(); len++) {
            String segment = s.substring(idx, idx + len);
            if ((segment.length() > 1 && segment.charAt(0) == '0') || Integer.parseInt(segment) > 255) continue;

            int prevLen = path.length();
            path.append(segment).append('.');
            backtrack(s, idx + len, parts + 1, path, res);
            path.setLength(prevLen);
        }
    }
}