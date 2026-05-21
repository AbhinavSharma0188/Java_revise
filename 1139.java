class Solution {

    public int largest1BorderedSquare(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] horizontal = new int[rows][cols];
        int[][] vertical = new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {

                    horizontal[i][j] =
                        (j > 0 ? horizontal[i][j - 1] : 0) + 1;

                    vertical[i][j] =
                        (i > 0 ? vertical[i - 1][j] : 0) + 1;
                }
            }
        }

        int maxSide = 0;

        for (int i = rows - 1; i >= 0; i--) {

            for (int j = cols - 1; j >= 0; j--) {

                int small = Math.min(horizontal[i][j], vertical[i][j]);

                while (small > maxSide) {

                    if (vertical[i][j - small + 1] >= small &&
                        horizontal[i - small + 1][j] >= small) {

                        maxSide = small;
                    }

                    small--;
                }
            }
        }

        return maxSide * maxSide;
    }
}