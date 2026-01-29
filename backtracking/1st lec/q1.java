public class q1 {

    public static void main(String[] args) {
        int n=4;
        boolean board[]=new boolean[n];
        int tq=2;
        permutation(board,0,tq,"");
        
    }
    public static void permutation(boolean board[],int qspf,int tq,String ans){
        for(int i=0;i<=board.length-1;i++){
            if(tq==qspf){
                System.out.println(ans);
                return;
            }
            if(board[i]==false){
                board[i]=true;
                permutation(board, qspf+1, tq, ans+"b"+i+"q"+qspf);
                board[i]=false;
            }
        }
    }
}