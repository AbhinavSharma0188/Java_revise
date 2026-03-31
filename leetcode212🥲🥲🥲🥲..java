class Solution {
    class Node {
        Node[] children = new Node[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();

        for(String w : words) {
            Node node = root;
            for(char c : w.toCharArray()) {
                int idx = c - 'a';
                if(node.children[idx] == null) {
                    node.children[idx] = new Node();
                }
                node = node.children[idx];
            }
            node.word = w;
        }

        List<String> res = new ArrayList<>();
        int m = board.length, n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(board, i, j, root, res);
            }
        }

        return res;
    }

    private void dfs(char[][] board, int i, int j, Node node, List<String> res) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;

        char c = board[i][j];
        if(c == '#' || node.children[c - 'a'] == null) return;

        node = node.children[c - 'a'];

        if(node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';

        dfs(board, i + 1, j, node, res);
        dfs(board, i - 1, j, node, res);
        dfs(board, i, j + 1, node, res);
        dfs(board, i, j - 1, node, res);

        board[i][j] = c;
    }
}