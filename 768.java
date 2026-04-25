class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        
        int[] leftMax = new int[n];
        int[] rightMin = new int[n + 1];

        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        rightMin[n] = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
        }

        int chunks = 0;
        for (int i = 0; i < n; i++) {
            if (leftMax[i] <= rightMin[i + 1]) {
                chunks++;
            }
        }

        return chunks;
    }
}