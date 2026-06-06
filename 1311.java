class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(id);
        visited[id] = true;
        
        int currentLevel = 0;
        
        while (!queue.isEmpty() && currentLevel < level) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int person = queue.poll();
                
                for (int friend : friends[person]) {
                    if (!visited[friend]) {
                        visited[friend] = true;
                        queue.offer(friend);
                    }
                }
            }
            
            currentLevel++;
        }
        
        Map<String, Integer> frequency = new HashMap<>();
        
        while (!queue.isEmpty()) {
            int person = queue.poll();
            
            for (String video : watchedVideos.get(person)) {
                frequency.put(video, frequency.getOrDefault(video, 0) + 1);
            }
        }
        
        List<String> result = new ArrayList<>(frequency.keySet());
        
        result.sort((a, b) -> {
            int cmp = Integer.compare(frequency.get(a), frequency.get(b));
            return cmp == 0 ? a.compareTo(b) : cmp;
        });
        
        return result;
    }
}