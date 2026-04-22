import java.util.*;

class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size();
        int n = forest.get(0).size();

        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[]{forest.get(i).get(j), i, j});
                }
            }
        }

        Collections.sort(trees, (a, b) -> a[0] - b[0]);

        int sr = 0, sc = 0, steps = 0;

        for (int[] tree : trees) {
            int d = bfs(forest, sr, sc, tree[1], tree[2]);
            if (d == -1) return -1;
            steps += d;
            sr = tree[1];
            sc = tree[2];
        }

        return steps;
    }

    private int bfs(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
        int m = forest.size();
        int n = forest.get(0).size();

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        q.offer(new int[]{sr, sc, 0});
        visited[sr][sc] = true;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], d = curr[2];

            if (r == tr && c == tc) return d;

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n &&
                    !visited[nr][nc] && forest.get(nr).get(nc) != 0) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, d + 1});
                }
            }
        }

        return -1;
    }
}