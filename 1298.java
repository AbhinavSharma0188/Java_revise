import java.util.*;

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] hasBox = new boolean[n];
        boolean[] used = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();

        for (int box : initialBoxes) {
            hasBox[box] = true;
            if (status[box] == 1) {
                queue.offer(box);
            }
        }

        int result = 0;

        while (!queue.isEmpty()) {
            int box = queue.poll();

            if (used[box]) continue;
            used[box] = true;

            result += candies[box];

            for (int key : keys[box]) {
                status[key] = 1;
                if (hasBox[key] && !used[key]) {
                    queue.offer(key);
                }
            }

            for (int newBox : containedBoxes[box]) {
                hasBox[newBox] = true;
                if (status[newBox] == 1 && !used[newBox]) {
                    queue.offer(newBox);
                }
            }
        }

        return result;
    }
}