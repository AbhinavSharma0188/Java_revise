class Solution {
    public boolean validTicTacToe(String[] board) {
        int x = 0, o = 0;
        
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X') x++;
                else if (c == 'O') o++;
            }
        }
        
        if (o > x || x - o > 1) return false;
        
        boolean xWin = win(board, 'X');
        boolean oWin = win(board, 'O');
        
        if (xWin && oWin) return false;
        if (xWin && x != o + 1) return false;
        if (oWin && x != o) return false;
        
        return true;
    }
    
    private boolean win(String[] b, char p) {
        for (int i = 0; i < 3; i++) {
            if (b[i].charAt(0) == p && b[i].charAt(1) == p && b[i].charAt(2) == p) return true;
            if (b[0].charAt(i) == p && b[1].charAt(i) == p && b[2].charAt(i) == p) return true;
        }
        
        if (b[0].charAt(0) == p && b[1].charAt(1) == p && b[2].charAt(2) == p) return true;
        if (b[0].charAt(2) == p && b[1].charAt(1) == p && b[2].charAt(0) == p) return true;
        
        return false;
    }
}