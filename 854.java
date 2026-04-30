import java.util.*;

class Solution {
    public int kSimilarity(String s1, String s2) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        q.offer(s1);
        visited.add(s1);
        
        int steps = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            while (size-- > 0) {
                String curr = q.poll();
                
                if (curr.equals(s2)) return steps;
                
                int i = 0;
                while (curr.charAt(i) == s2.charAt(i)) i++;
                
                for (int j = i + 1; j < curr.length(); j++) {
                    if (curr.charAt(j) == s2.charAt(i) && curr.charAt(j) != s2.charAt(j)) {
                        String next = swap(curr, i, j);
                        
                        if (!visited.contains(next)) {
                            visited.add(next);
                            q.offer(next);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    
    private String swap(String s, int i, int j) {
        char[] arr = s.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}