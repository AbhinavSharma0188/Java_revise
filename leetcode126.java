class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!dict.contains(endWord)) return res;

        Map<String, List<String>> map = new HashMap<>();
        Set<String> start = new HashSet<>(), end = new HashSet<>();
        start.add(beginWord);
        end.add(endWord);

        boolean found = false, backward = false;

        while (!start.isEmpty() && !end.isEmpty() && !found) {
            if (start.size() > end.size()) {
                Set<String> temp = start;
                start = end;
                end = temp;
                backward = !backward;
            }

            dict.removeAll(start);
            Set<String> next = new HashSet<>();

            for (String word : start) {
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String newWord = new String(arr);
                        if (!dict.contains(newWord) && !end.contains(newWord)) continue;

                        String key = backward ? newWord : word;
                        String val = backward ? word : newWord;

                        map.computeIfAbsent(key, k -> new ArrayList<>()).add(val);

                        if (end.contains(newWord)) found = true;
                        else next.add(newWord);
                    }
                    arr[i] = old;
                }
            }
            start = next;
        }

        if (found) {
            List<String> path = new ArrayList<>();
            path.add(beginWord);
            dfs(beginWord, endWord, map, res, path);
        }

        return res;
    }

    void dfs(String word, String endWord, Map<String, List<String>> map, List<List<String>> res, List<String> path) {
        if (word.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (!map.containsKey(word)) return;

        for (String next : map.get(word)) {
            path.add(next);
            dfs(next, endWord, map, res, path);
            path.remove(path.size() - 1);
        }
    }
}