class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] stones = {a, b, c};
        Arrays.sort(stones);

        a = stones[0];
        b = stones[1];
        c = stones[2];

        int min;

        if (c - a == 2) {
            min = 0;
        } else if (b - a <= 2 || c - b <= 2) {
            min = 1;
        } else {
            min = 2;
        }

        int max = (c - a - 2);

        return new int[]{min, max};
    }
}