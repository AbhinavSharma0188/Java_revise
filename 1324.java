class Solution {
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        int maxLen = 0;

        for (String word : words) {
            maxLen = Math.max(maxLen, word.length());
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < maxLen; i++) {
            StringBuilder sb = new StringBuilder();

            for (String word : words) {
                if (i < word.length()) {
                    sb.append(word.charAt(i));
                } else {
                    sb.append(' ');
                }
            }

            while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }

            result.add(sb.toString());
        }

        return result;
    }
}