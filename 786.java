import java.util.*;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> arr[a[0]] * arr[b[1]] - arr[b[0]] * arr[a[1]]
        );
        
        for (int j = 1; j < n; j++) {
            pq.offer(new int[]{0, j});
        }
        
        while (--k > 0) {
            int[] cur = pq.poll();
            int i = cur[0], j = cur[1];
            
            if (i + 1 < j) {
                pq.offer(new int[]{i + 1, j});
            }
        }
        
        int[] res = pq.peek();
        return new int[]{arr[res[0]], arr[res[1]]};
    }
}