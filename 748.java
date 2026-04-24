class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] target = count(licensePlate);
        String res = null;
        
        for (String word : words) {
            if (res != null && word.length() >= res.length()) continue;
            if (isValid(word, target)) {
                res = word;
            }
        }
        
        return res;
    }
    
    private int[] count(String s) {
        int[] arr = new int[26];
        for (char c : s.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                arr[c - 'a']++;
            }
        }
        return arr;
    }
    
    private boolean isValid(String word, int[] target) {
        int[] arr = new int[26];
        for (char c : word.toCharArray()) {
            arr[c - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (arr[i] < target[i]) return false;
        }
        
        return true;
    }
}