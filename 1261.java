import java.util.HashSet;
import java.util.Set;

import javax.swing.tree.TreeNode;

class FindElements {
    private Set<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        recover(root, 0);
    }

    private void recover(TreeNode node, int val) {
        if (node == null) return;
        node.val = val;
        set.add(val);
        recover(node.left, 2 * val + 1);
        recover(node.right, 2 * val + 2);
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}