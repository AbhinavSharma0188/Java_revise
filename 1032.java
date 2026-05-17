class StreamChecker {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    TrieNode root;
    StringBuilder stream;

    public StreamChecker(String[] words) {
        root = new TrieNode();
        stream = new StringBuilder();

        for (String word : words) {
            insert(word);
        }
    }

    private void insert(String word) {
        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);

            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }

            node = node.children[ch - 'a'];
        }

        node.isWord = true;
    }

    public boolean query(char letter) {
        stream.append(letter);

        TrieNode node = root;

        for (int i = stream.length() - 1; i >= 0; i--) {
            char ch = stream.charAt(i);

            if (node.children[ch - 'a'] == null) {
                return false;
            }

            node = node.children[ch - 'a'];

            if (node.isWord) {
                return true;
            }
        }

        return false;
    }
}