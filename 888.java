class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;
        for (int a : aliceSizes) sumA += a;
        for (int b : bobSizes) sumB += b;

        int diff = (sumA - sumB) / 2;

        java.util.HashSet<Integer> set = new java.util.HashSet<>();
        for (int b : bobSizes) set.add(b);

        for (int a : aliceSizes) {
            if (set.contains(a - diff)) {
                return new int[]{a, a - diff};
            }
        }
        return new int[0];
    }
}