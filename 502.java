class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        
        java.util.Arrays.sort(projects, (a, b) -> a[0] - b[0]);
        
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>((a, b) -> b - a);
        int i = 0;
        
        while (k-- > 0) {
            while (i < n && projects[i][0] <= w) {
                pq.offer(projects[i][1]);
                i++;
            }
            
            if (pq.isEmpty()) break;
            w += pq.poll();
        }
        
        return w;
    }
}