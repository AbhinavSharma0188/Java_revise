class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] reach = new boolean[numCourses][numCourses];

        for (int[] p : prerequisites) {
            reach[p[0]][p[1]] = true;
        }

        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                if (!reach[i][k]) continue;
                for (int j = 0; j < numCourses; j++) {
                    reach[i][j] |= reach[k][j];
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {
            ans.add(reach[q[0]][q[1]]);
        }

        return ans;
    }
}