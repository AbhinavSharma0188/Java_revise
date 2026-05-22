class Solution {
    public int[][] marketAnalysis(int[][] orders, int[][] items) {
        int n = orders.length;
        int[][] result = new int[n][2];

        for (int i = 0; i < n; i++) {
            result[i][0] = orders[i][0]; // customer id
            result[i][1] = orders[i][2]; // total orders
        }

        return result;
    }
}