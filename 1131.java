class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {

        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;

        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;

        int max3 = Integer.MIN_VALUE;
        int min3 = Integer.MAX_VALUE;

        int max4 = Integer.MIN_VALUE;
        int min4 = Integer.MAX_VALUE;

        for (int i = 0; i < arr1.length; i++) {

            int val1 = arr1[i] + arr2[i] + i;
            int val2 = arr1[i] + arr2[i] - i;
            int val3 = arr1[i] - arr2[i] + i;
            int val4 = arr1[i] - arr2[i] - i;

            max1 = Math.max(max1, val1);
            min1 = Math.min(min1, val1);

            max2 = Math.max(max2, val2);
            min2 = Math.min(min2, val2);

            max3 = Math.max(max3, val3);
            min3 = Math.min(min3, val3);

            max4 = Math.max(max4, val4);
            min4 = Math.min(min4, val4);
        }

        return Math.max(
            Math.max(max1 - min1, max2 - min2),
            Math.max(max3 - min3, max4 - min4)
        );
    }
}