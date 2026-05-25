class Solution {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        int n = s.length();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> pair : pairs) {
            int u = pair.get(0);
            int v = pair.get(1);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        char[] result = s.toCharArray();

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                List<Integer> indices = new ArrayList<>();

                List<Character> chars = new ArrayList<>();

                dfs(i, graph, visited, indices, chars, s);

                Collections.sort(indices);
                Collections.sort(chars);

                for (int j = 0; j < indices.size(); j++) {
                    result[indices.get(j)] = chars.get(j);
                }
            }
        }

        return new String(result);
    }

    private void dfs(int node,
                     List<List<Integer>> graph,
                     boolean[] visited,
                     List<Integer> indices,
                     List<Character> chars,
                     String s) {

        visited[node] = true;

        indices.add(node);

        chars.add(s.charAt(node));

        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, indices, chars, s);
            }
        }
    }
}