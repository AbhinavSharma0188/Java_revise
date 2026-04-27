class Solution {
    int[] parent, size;
    int rows, cols;

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) return;

        if (size[pa] < size[pb]) {
            parent[pa] = pb;
            size[pb] += size[pa];
        } else {
            parent[pb] = pa;
            size[pa] += size[pb];
        }
    }

    public int index(int r, int c) {
        return r * cols + c;
    }

    public int[] hitBricks(int[][] grid, int[][] hits) {
        rows = grid.length;
        cols = grid[0].length;

        int[][] copy = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            copy[i] = grid[i].clone();
        }

        for (int[] h : hits) {
            if (copy[h[0]][h[1]] == 1) {
                copy[h[0]][h[1]] = 0;
            }
        }

        parent = new int[rows * cols + 1];
        size = new int[rows * cols + 1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int top = rows * cols;

        for (int c = 0; c < cols; c++) {
            if (copy[0][c] == 1) {
                union(index(0, c), top);
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (copy[r][c] == 1) {
                    for (int[] d : dirs) {
                        int nr = r + d[0], nc = c + d[1];
                        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && copy[nr][nc] == 1) {
                            union(index(r, c), index(nr, nc));
                        }
                    }
                }
            }
        }

        int[] res = new int[hits.length];

        for (int i = hits.length - 1; i >= 0; i--) {
            int r = hits[i][0], c = hits[i][1];

            if (grid[r][c] == 0) continue;

            int prevTop = size[find(top)];

            copy[r][c] = 1;

            if (r == 0) {
                union(index(r, c), top);
            }

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && copy[nr][nc] == 1) {
                    union(index(r, c), index(nr, nc));
                }
            }

            int newTop = size[find(top)];
            res[i] = Math.max(0, newTop - prevTop - 1);
        }

        return res;
    }
}