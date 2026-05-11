class Solution {
    int[] parent;

    public int largestComponentSize(int[] nums) {
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        parent = new int[max + 1];

        for (int i = 0; i <= max; i++) {
            parent[i] = i;
        }

        for (int num : nums) {
            for (int factor = 2; factor * factor <= num; factor++) {
                if (num % factor == 0) {
                    union(num, factor);
                    union(num, num / factor);
                }
            }
        }

        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;

        for (int num : nums) {
            int root = find(num);
            count.put(root, count.getOrDefault(root, 0) + 1);
            ans = Math.max(ans, count.get(root));
        }

        return ans;
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