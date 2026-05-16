class Solution {
    int index = 0;

    public TreeNode recoverFromPreorder(String traversal) {
        return build(traversal, 0);
    }

    private TreeNode build(String s, int depth) {
        int dash = 0;
        int temp = index;

        while (temp < s.length() && s.charAt(temp) == '-') {
            dash++;
            temp++;
        }

        if (dash != depth) {
            return null;
        }

        index = temp;
        int value = 0;

        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            value = value * 10 + (s.charAt(index) - '0');
            index++;
        }

        TreeNode node = new TreeNode(value);

        node.left = build(s, depth + 1);
        node.right = build(s, depth + 1);

        return node;
    }
}