class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] order = new int[numCourses];
        int idx = 0;

        while(!q.isEmpty()) {
            int node = q.poll();
            order[idx++] = node;

            for(int nei : graph.get(node)) {
                indegree[nei]--;
                if(indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        if(idx == numCourses) return order;
        return new int[0];
    }
}