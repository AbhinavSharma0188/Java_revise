import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int minCol = 0;

            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] < matrix[i][minCol]) {
                    minCol = j;
                }
            }

            int value = matrix[i][minCol];
            boolean isLucky = true;

            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][minCol] > value) {
                    isLucky = false;
                    break;
                }
            }

            if (isLucky) {
                result.add(value);
            }
        }

        return result;
    }
}