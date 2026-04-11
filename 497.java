class Solution {
    java.util.List<int[]> rects;
    int[] prefix;
    java.util.Random rand;

    public Solution(int[][] rects) {
        this.rects = new java.util.ArrayList<>();
        prefix = new int[rects.length];
        rand = new java.util.Random();
        int sum = 0;
        for (int i = 0; i < rects.length; i++) {
            this.rects.add(rects[i]);
            int[] r = rects[i];
            sum += (r[2] - r[0] + 1) * (r[3] - r[1] + 1);
            prefix[i] = sum;
        }
    }

    public int[] pick() {
        int target = rand.nextInt(prefix[prefix.length - 1]) + 1;
        int idx = binarySearch(target);
        int[] r = rects.get(idx);
        int x = r[0] + rand.nextInt(r[2] - r[0] + 1);
        int y = r[1] + rand.nextInt(r[3] - r[1] + 1);
        return new int[]{x, y};
    }

    private int binarySearch(int target) {
        int l = 0, h = prefix.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (prefix[m] < target) l = m + 1;
            else h = m;
        }
        return l;
    }
}