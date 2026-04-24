class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        
        for (String s : allowed) {
            String key = s.substring(0, 2);
            char val = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(val);
        }
        
        return dfs(bottom, map);
    }
    
    private boolean dfs(String row, Map<String, List<Character>> map) {
        if (row.length() == 1) return true;
        
        List<String> nextRows = new ArrayList<>();
        buildNext(row, 0, new StringBuilder(), map, nextRows);
        
        for (String next : nextRows) {
            if (dfs(next, map)) return true;
        }
        
        return false;
    }
    
    private void buildNext(String row, int idx, StringBuilder sb,
                           Map<String, List<Character>> map, List<String> res) {
        if (idx == row.length() - 1) {
            res.add(sb.toString());
            return;
        }
        
        String key = "" + row.charAt(idx) + row.charAt(idx + 1);
        if (!map.containsKey(key)) return;
        
        for (char c : map.get(key)) {
            sb.append(c);
            buildNext(row, idx + 1, sb, map, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}