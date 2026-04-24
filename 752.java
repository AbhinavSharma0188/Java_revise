class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) return -1;
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer("0000");
        visited.add("0000");
        
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                
                if (curr.equals(target)) return steps;
                
                for (String next : neighbors(curr)) {
                    if (!dead.contains(next) && !visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            
            steps++;
        }
        
        return -1;
    }
    
    private List<String> neighbors(String s) {
        List<String> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        
        for (int i = 0; i < 4; i++) {
            char ch = arr[i];
            
            arr[i] = (char)((ch - '0' + 1) % 10 + '0');
            res.add(new String(arr));
            
            arr[i] = (char)((ch - '0' + 9) % 10 + '0');
            res.add(new String(arr));
            
            arr[i] = ch;
        }
        
        return res;
    }
}