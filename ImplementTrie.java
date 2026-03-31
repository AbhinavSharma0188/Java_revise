class Trie {

    class Node {
        Node[] children = new Node[26];
        boolean isEnd = false;
    }

    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(char c : word.toCharArray()) {
            int idx = c - 'a';
            if(node.children[idx] == null) {
                node.children[idx] = new Node();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        Node node = root;
        for(char c : word.toCharArray()) {
            int idx = c - 'a';
            if(node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if(node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
        }
        return true;
    }
}