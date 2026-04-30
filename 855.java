import java.util.*;

class ExamRoom {
    private int n;
    private PriorityQueue<int[]> pq;

    public ExamRoom(int n) {
        this.n = n;
        pq = new PriorityQueue<>((a, b) -> {
            int distA = distance(a);
            int distB = distance(b);
            if (distA == distB) return a[0] - b[0];
            return distB - distA;
        });
        pq.offer(new int[]{-1, n});
    }

    public int seat() {
        int[] interval = pq.poll();
        int start = interval[0], end = interval[1];
        
        int seat;
        if (start == -1) {
            seat = 0;
        } else if (end == n) {
            seat = n - 1;
        } else {
            seat = start + (end - start) / 2;
        }
        
        pq.offer(new int[]{start, seat});
        pq.offer(new int[]{seat, end});
        
        return seat;
    }

    public void leave(int p) {
        int[] left = null, right = null;
        
        List<int[]> temp = new ArrayList<>();
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[1] == p) left = curr;
            else if (curr[0] == p) right = curr;
            else temp.add(curr);
        }
        
        pq.addAll(temp);
        pq.offer(new int[]{left[0], right[1]});
    }

    private int distance(int[] interval) {
        int start = interval[0], end = interval[1];
        
        if (start == -1) return end;
        if (end == n) return n - 1 - start;
        
        return (end - start) / 2;
    }
}