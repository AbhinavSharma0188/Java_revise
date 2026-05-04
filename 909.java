import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] vis = new boolean[n * n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        vis[1] = true;
        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int curr = q.poll();
                if (curr == n * n) return moves;

                for (int i = 1; i <= 6 && curr + i <= n * n; i++) {
                    int next = curr + i;
                    int[] pos = getPos(next, n);
                    int r = pos[0], c = pos[1];

                    if (board[r][c] != -1) next = board[r][c];

                    if (!vis[next]) {
                        vis[next] = true;
                        q.offer(next);
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    private int[] getPos(int num, int n) {
        int r = n - 1 - (num - 1) / n;
        int c = (num - 1) % n;
        if (((n - 1 - r) % 2) == 1) c = n - 1 - c;
        return new int[]{r, c};
    }
}