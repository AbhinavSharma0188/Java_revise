class Solution {
    public int numSpecialEquivGroups(String[] words) {
        java.util.HashSet<String> set = new java.util.HashSet<>();

        for (String word : words) {
            int[] even = new int[26];
            int[] odd = new int[26];

            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) {
                    even[word.charAt(i) - 'a']++;
                } else {
                    odd[word.charAt(i) - 'a']++;
                }
            }

            String key = java.util.Arrays.toString(even) + java.util.Arrays.toString(odd);
            set.add(key);
        }

        return set.size();
    }
}