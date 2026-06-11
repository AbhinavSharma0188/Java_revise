import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        for (int row = 0; row < m; row++) {
            sortDiagonal(mat, row, 0);
        }

        for (int col = 1; col < n; col++) {
            sortDiagonal(mat, 0, col);
        }

        return mat;
    }

    private void sortDiagonal(int[][] mat, int row, int col) {
        int m = mat.length;
        int n = mat[0].length;
        List<Integer> diagonal = new ArrayList<>();

        int r = row, c = col;
        while (r < m && c < n) {
            diagonal.add(mat[r][c]);
            r++;
            c++;
        }

        Collections.sort(diagonal);

        r = row;
        c = col;
        int idx = 0;

        while (r < m && c < n) {
            mat[r][c] = diagonal.get(idx++);
            r++;
            c++;
        }
    }
}