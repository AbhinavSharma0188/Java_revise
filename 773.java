class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = "";

        for (int[] row : board) {
            for (int num : row) {
                start += num;
            }
        }

        int[][] dirs = {
            {1,3},
            {0,2,4},
            {1,5},
            {0,4},
            {1,3,5},
            {2,4}
        };

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer(start);
        visited.add(start);

        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String curr = q.poll();

                if (curr.equals(target)) return moves;

                int zero = curr.indexOf('0');

                for (int next : dirs[zero]) {
                    char[] arr = curr.toCharArray();
                    char temp = arr[zero];
                    arr[zero] = arr[next];
                    arr[next] = temp;

                    String newState = new String(arr);

                    if (!visited.contains(newState)) {
                        visited.add(newState);
                        q.offer(newState);
                    }
                }
            }
            moves++;
        }

        return -1;
    }
}