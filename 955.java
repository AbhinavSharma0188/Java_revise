class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();

        boolean[] sorted = new boolean[rows - 1];
        int deletions = 0;

        for (int col = 0; col < cols; col++) {
            boolean invalid = false;

            for (int row = 0; row < rows - 1; row++) {
                if (!sorted[row] && strs[row].charAt(col) > strs[row + 1].charAt(col)) {
                    invalid = true;
                    break;
                }
            }

            if (invalid) {
                deletions++;
                continue;
            }

            for (int row = 0; row < rows - 1; row++) {
                if (strs[row].charAt(col) < strs[row + 1].charAt(col)) {
                    sorted[row] = true;
                }
            }
        }

        return deletions;
    }
}