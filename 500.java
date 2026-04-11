class Solution {
    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        
        java.util.List<String> res = new java.util.ArrayList<>();
        
        for (String word : words) {
            String w = word.toLowerCase();
            String row = "";
            
            if (row1.indexOf(w.charAt(0)) != -1) row = row1;
            else if (row2.indexOf(w.charAt(0)) != -1) row = row2;
            else row = row3;
            
            boolean ok = true;
            for (char ch : w.toCharArray()) {
                if (row.indexOf(ch) == -1) {
                    ok = false;
                    break;
                }
            }
            
            if (ok) res.add(word);
        }
        
        return res.toArray(new String[0]);
    }
}