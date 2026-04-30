import java.util.*;

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] workers = new double[n][2];
        
        for (int i = 0; i < n; i++) {
            workers[i][0] = (double) wage[i] / quality[i]; // ratio
            workers[i][1] = quality[i];
        }
        
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        double result = Double.MAX_VALUE;
        
        for (double[] worker : workers) {
            int q = (int) worker[1];
            maxHeap.offer(q);
            sum += q;
            
            if (maxHeap.size() > k) {
                sum -= maxHeap.poll();
            }
            
            if (maxHeap.size() == k) {
                result = Math.min(result, worker[0] * sum);
            }
        }
        
        return result;
    }
}