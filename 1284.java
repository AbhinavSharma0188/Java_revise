import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Solution {
    public int minFlips(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int start = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    start |= 1 << (i * n + j);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        int[][] dirs = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                int state = queue.poll();

                if (state == 0) {
                    return steps;
                }

                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        int next = state;

                        for (int[] d : dirs) {
                            int ni = i + d[0];
                            int nj = j + d[1];

                            if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                                next ^= 1 << (ni * n + nj);
                            }
                        }

                        if (visited.add(next)) {
                            queue.offer(next);
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}