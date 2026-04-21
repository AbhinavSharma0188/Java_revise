import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            pq.offer(new int[]{val, i, 0});
            max = Math.max(max, val);
        }
        
        int start = 0, end = Integer.MAX_VALUE;
        
        while (pq.size() == nums.size()) {
            int[] curr = pq.poll();
            int min = curr[0];
            
            if (max - min < end - start) {
                start = min;
                end = max;
            }
            
            int listIndex = curr[1];
            int elementIndex = curr[2];
            
            if (elementIndex + 1 < nums.get(listIndex).size()) {
                int nextVal = nums.get(listIndex).get(elementIndex + 1);
                pq.offer(new int[]{nextVal, listIndex, elementIndex + 1});
                max = Math.max(max, nextVal);
            }
        }
        
        return new int[]{start, end};
    }
}