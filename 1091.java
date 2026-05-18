import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});

        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int row = curr[0];
            int col = curr[1];
            int dist = curr[2];

            if (row == n - 1 && col == n - 1) {
                return dist;
            }

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newCol >= 0 &&
                    newRow < n && newCol < n &&
                    grid[newRow][newCol] == 0) {

                    queue.offer(new int[]{newRow, newCol, dist + 1});
                    grid[newRow][newCol] = 1;
                }
            }
        }

        return -1;
    }
}