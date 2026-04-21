import java.util.*;

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String path : paths) {
            String[] parts = path.split(" ");
            String dir = parts[0];
            
            for (int i = 1; i < parts.length; i++) {
                String file = parts[i];
                
                int idx1 = file.indexOf('(');
                int idx2 = file.indexOf(')');
                
                String fileName = file.substring(0, idx1);
                String content = file.substring(idx1 + 1, idx2);
                
                String fullPath = dir + "/" + fileName;
                
                map.computeIfAbsent(content, k -> new ArrayList<>()).add(fullPath);
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        
        for (List<String> group : map.values()) {
            if (group.size() > 1) {
                res.add(group);
            }
        }
        
        return res;
    }
}