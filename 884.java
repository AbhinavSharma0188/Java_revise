class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        java.util.Map<String, Integer> map = new java.util.HashMap<>();
        
        for (String w : (s1 + " " + s2).split(" ")) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        
        java.util.List<String> res = new java.util.ArrayList<>();
        for (String w : map.keySet()) {
            if (map.get(w) == 1) res.add(w);
        }
        
        return res.toArray(new String[0]);
    }
}