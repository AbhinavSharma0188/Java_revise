class Solution {
    public int minAddToMakeValid(String s) {
        int balance = 0, moves = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else {
                if (balance == 0) {
                    moves++;
                } else {
                    balance--;
                }
            }
        }
        return moves + balance;
    }
}