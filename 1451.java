import java.util.*;

class Solution {
    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        words[0] = Character.toLowerCase(words[0].charAt(0)) + words[0].substring(1);

        List<String> list = new ArrayList<>(Arrays.asList(words));
        list.sort(Comparator.comparingInt(String::length));

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) ans.append(" ");
            ans.append(list.get(i));
        }

        ans.setCharAt(0, Character.toUpperCase(ans.charAt(0)));
        return ans.toString();
    }
}