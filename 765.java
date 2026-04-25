class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            pos[row[i]] = i;
        }

        int swaps = 0;

        for (int i = 0; i < n; i += 2) {
            int x = row[i];
            int partner = x ^ 1;

            if (row[i + 1] != partner) {
                swaps++;
                int partnerIndex = pos[partner];

                pos[row[i + 1]] = partnerIndex;
                row[partnerIndex] = row[i + 1];

                row[i + 1] = partner;
                pos[partner] = i + 1;
            }
        }

        return swaps;
    }
}