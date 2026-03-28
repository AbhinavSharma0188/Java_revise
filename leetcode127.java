class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) {
                    char old = arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        arr[j] = c;
                        String next = new String(arr);

                        if (next.equals(endWord)) return level + 1;

                        if (dict.contains(next)) {
                            q.add(next);
                            dict.remove(next);
                        }
                    }
                    arr[j] = old;
                }
            }
            level++;
        }
        return 0;
    }
}