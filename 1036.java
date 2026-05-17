class Solution {
    private static final int LIMIT = 1000000;
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blockedSet = new HashSet<>();

        for (int[] b : blocked) {
            blockedSet.add(b[0] + "," + b[1]);
        }

        return bfs(source, target, blockedSet) &&
               bfs(target, source, blockedSet);
    }

    private boolean bfs(int[] start, int[] finish, Set<String> blockedSet) {
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(start);
        visited.add(start[0] + "," + start[1]);

        int maxArea = 20000;

        while (!queue.isEmpty() && visited.size() <= maxArea) {
            int[] curr = queue.poll();

            if (curr[0] == finish[0] && curr[1] == finish[1]) {
                return true;
            }

            for (int[] dir : DIRS) {
                int nx = curr[0] + dir[0];
                int ny = curr[1] + dir[1];

                String key = nx + "," + ny;

                if (nx >= 0 && ny >= 0 && nx < LIMIT && ny < LIMIT &&
                    !blockedSet.contains(key) &&
                    !visited.contains(key)) {

                    visited.add(key);
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return visited.size() > maxArea;
    }
}