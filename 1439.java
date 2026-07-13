import java.util.*;

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        List<Integer> prev = new ArrayList<>();
        prev.add(0);

        for (int[] row : mat) {
            List<Integer> curr = new ArrayList<>();

            for (int sum : prev) {
                for (int val : row) {
                    curr.add(sum + val);
                }
            }

            Collections.sort(curr);

            if (curr.size() > k) {
                curr = new ArrayList<>(curr.subList(0, k));
            }

            prev = curr;
        }

        return prev.get(k - 1);
    }
}