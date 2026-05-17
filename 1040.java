class Solution {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);

        int n = stones.length;

        int maxMoves = Math.max(
                stones[n - 1] - stones[1] + 1 - (n - 1),
                stones[n - 2] - stones[0] + 1 - (n - 1)
        );

        int minMoves = n;

        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j + 1 < n && stones[j + 1] - stones[i] + 1 <= n) {
                j++;
            }

            int alreadyPlaced = j - i + 1;

            if (alreadyPlaced == n - 1 &&
                stones[j] - stones[i] + 1 == n - 1) {
                minMoves = Math.min(minMoves, 2);
            } else {
                minMoves = Math.min(minMoves, n - alreadyPlaced);
            }
        }

        return new int[]{minMoves, maxMoves};
    }
}