import java.util.*;

class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        List<String> list = new ArrayList<>(Arrays.asList(wordlist));
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            String guess = list.get(rand.nextInt(list.size()));
            int matches = master.guess(guess);

            List<String> next = new ArrayList<>();
            for (String word : list) {
                if (matchCount(guess, word) == matches) {
                    next.add(word);
                }
            }
            list = next;
        }
    }

    private int matchCount(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) count++;
        }
        return count;
    }
}