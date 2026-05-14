class Solution {
    class Pair {
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 0, 0));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();

            map.putIfAbsent(curr.col, new ArrayList<>());
            map.get(curr.col).add(new int[]{curr.row, curr.node.val});

            if (curr.node.left != null) {
                queue.offer(new Pair(curr.node.left, curr.row + 1, curr.col - 1));
            }

            if (curr.node.right != null) {
                queue.offer(new Pair(curr.node.right, curr.row + 1, curr.col + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (List<int[]> list : map.values()) {
            Collections.sort(list, (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            });

            List<Integer> temp = new ArrayList<>();

            for (int[] arr : list) {
                temp.add(arr[1]);
            }

            ans.add(temp);
        }

        return ans;
    }
}