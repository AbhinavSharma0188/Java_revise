import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;

        for (int num : target) {
            pq.offer(num);
            sum += num;
        }

        while (true) {
            int max = pq.poll();
            long rest = sum - max;

            if (max == 1 || rest == 1) {
                return true;
            }

            if (rest == 0 || max < rest || max % rest == 0) {
                return false;
            }

            int updated = (int)(max % rest);
            sum = rest + updated;
            pq.offer(updated);
        }
    }
}