import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, val);
            graph.get(b).put(a, 1.0 / val);
        }

        double[] res = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
                res[i] = -1.0;
            } else if (src.equals(dest)) {
                res[i] = 1.0;
            } else {
                res[i] = dfs(graph, src, dest, 1.0, new HashSet<>());
            }
        }

        return res;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String curr, String target, double product, Set<String> visited) {
        visited.add(curr);

        if (graph.get(curr).containsKey(target)) {
            return product * graph.get(curr).get(target);
        }

        for (String next : graph.get(curr).keySet()) {
            if (!visited.contains(next)) {
                double result = dfs(graph, next, target, product * graph.get(curr).get(next), visited);
                if (result != -1.0) {
                    return result;
                }
            }
        }

        return -1.0;
    }
}