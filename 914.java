class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int d : deck) map.put(d, map.getOrDefault(d, 0) + 1);

        int g = 0;
        for (int count : map.values()) {
            g = gcd(g, count);
        }

        return g > 1;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}