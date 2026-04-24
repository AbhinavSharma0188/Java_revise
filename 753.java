class Solution {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        Set<String> seen = new HashSet<>();
        String start = "0".repeat(n - 1);
        
        dfs(start, k, seen, sb);
        sb.append(start);
        
        return sb.toString();
    }
    
    private void dfs(String node, int k, Set<String> seen, StringBuilder sb) {
        for (int i = 0; i < k; i++) {
            String edge = node + i;
            if (!seen.contains(edge)) {
                seen.add(edge);
                dfs(edge.substring(1), k, seen, sb);
                sb.append(i);
            }
        }
    }
}