class Solution {
    int[] parent;

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int size = n * n * 4;

        parent = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int root = 4 * (r * n + c);
                char ch = grid[r].charAt(c);

                if (ch != '\\') {
                    union(root, root + 1);
                    union(root + 2, root + 3);
                }

                if (ch != '/') {
                    union(root, root + 2);
                    union(root + 1, root + 3);
                }

                if (r + 1 < n) {
                    union(root + 3, 4 * ((r + 1) * n + c) + 1);
                }

                if (c + 1 < n) {
                    union(root + 2, 4 * (r * n + c + 1));
                }
            }
        }

        int regions = 0;

        for (int i = 0; i < size; i++) {
            if (parent[i] == i) {
                regions++;
            }
        }

        return regions;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    private void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa != pb) {
            parent[pa] = pb;
        }
    }
}