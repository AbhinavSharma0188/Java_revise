public class q1{
    public static void main(String[] args) {
        int n=4;
        boolean board[][]=new boolean[n][n];
        int tq=4;
        
        
        nqueen(board,tq,0);
    }
    public static void nqueen(boolean board[][],int tq,int row){
         if(tq==0){
                Display(board);
                return;
            }
        for(int col=0;col<=board.length-1;col++){
           
            if(qpsf(board,row,col)){
                board[row][col]=true;
                nqueen(board, tq-1, row+1);
                board[row][col]=false;

            }
        }
       

    }
    public static void Display(boolean board[][]){
        for(int row=0;row<=board.length-1;row++){
            for(int col=0;col<=board.length-1;col++){
                System.out.print(board[row][col]);
            }
            System.out.println();

        }
        System.out.println();
    }
   
    public static boolean qpsf(boolean[][] board, int row, int col) {

    int r, c;

    // vertical up
    r = row - 1;
    c = col;
    while (r >= 0) {
        if (board[r][c]) return false;
        r--;
    }

    // left diagonal
    r = row - 1;
    c = col - 1;
    while (r >= 0 && c >= 0) {
        if (board[r][c]) return false;
        r--;
        c--;
    }

    // right diagonal
    r = row - 1;
    c = col + 1;
    while (r >= 0 && c < board.length) {
        if (board[r][c]) return false;
        r--;
        c++;
    }

    return true;
}

}