class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        java.util.Set<String> exact = new java.util.HashSet<>();
        java.util.Map<String, String> caseMap = new java.util.HashMap<>();
        java.util.Map<String, String> vowelMap = new java.util.HashMap<>();

        for (String word : wordlist) {
            exact.add(word);

            String lower = word.toLowerCase();
            caseMap.putIfAbsent(lower, word);

            String devowel = normalize(lower);
            vowelMap.putIfAbsent(devowel, word);
        }

        String[] result = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            if (exact.contains(query)) {
                result[i] = query;
                continue;
            }

            String lower = query.toLowerCase();

            if (caseMap.containsKey(lower)) {
                result[i] = caseMap.get(lower);
                continue;
            }

            String devowel = normalize(lower);

            result[i] = vowelMap.getOrDefault(devowel, "");
        }

        return result;
    }

    private String normalize(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}