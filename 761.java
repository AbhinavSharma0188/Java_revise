class Solution {
    public String makeLargestSpecial(String s) {
        int count = 0, start = 0;
        List<String> res = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') count++;
            else count--;

            if (count == 0) {
                String inner = s.substring(start + 1, i);
                res.add("1" + makeLargestSpecial(inner) + "0");
                start = i + 1;
            }
        }

        Collections.sort(res, Collections.reverseOrder());
        return String.join("", res);
    }
}