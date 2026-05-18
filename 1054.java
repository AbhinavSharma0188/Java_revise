import java.util.*;

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : barcodes) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );
        
        for (int key : map.keySet()) {
            pq.offer(new int[]{key, map.get(key)});
        }
        
        int[] result = new int[barcodes.length];
        int idx = 0;
        
        while (pq.size() >= 2) {
            int[] first = pq.poll();
            int[] second = pq.poll();
            
            result[idx++] = first[0];
            result[idx++] = second[0];
            
            if (--first[1] > 0) {
                pq.offer(first);
            }
            
            if (--second[1] > 0) {
                pq.offer(second);
            }
        }
        
        if (!pq.isEmpty()) {
            result[idx] = pq.poll()[0];
        }
        
        return result;
    }
}