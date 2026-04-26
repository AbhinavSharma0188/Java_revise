import java.util.*;

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<Queue<int[]>> buckets = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            buckets.add(new LinkedList<>());
        }
        
        for (int i = 0; i < words.length; i++) {
            buckets.get(words[i].charAt(0) - 'a')
                   .offer(new int[]{i, 0});
        }
        
        int count = 0;
        
        for (char c : s.toCharArray()) {
            Queue<int[]> q = buckets.get(c - 'a');
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int wordIndex = cur[0];
                int charIndex = cur[1] + 1;
                
                if (charIndex == words[wordIndex].length()) {
                    count++;
                } else {
                    char next = words[wordIndex].charAt(charIndex);
                    buckets.get(next - 'a')
                           .offer(new int[]{wordIndex, charIndex});
                }
            }
        }
        
        return count;
    }
}