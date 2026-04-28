class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        List<Integer>[] index = new List[26];

        for (int i = 0; i < 26; i++) {
            index[i] = new ArrayList<>();
            index[i].add(-1);
        }

        for (int i = 0; i < n; i++) {
            index[s.charAt(i) - 'A'].add(i);
        }

        for (int i = 0; i < 26; i++) {
            index[i].add(n);
        }

        int res = 0;

        for (int i = 0; i < 26; i++) {
            List<Integer> list = index[i];
            for (int j = 1; j < list.size() - 1; j++) {
                res += (list.get(j) - list.get(j - 1)) * 
                       (list.get(j + 1) - list.get(j));
            }
        }

        return res;
    }
}