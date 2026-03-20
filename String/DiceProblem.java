public class DiceProblem {
    public static void main(String[] args) {
        int n=4;
        printDice(n,0," ");
    }
    public static void printDice(int n,int curr,String ans){
        if(curr==n){
            System.out.println(ans);
            return;
        }
        if(curr>n){
            return;
        }
        printDice(n, curr+1, ans+1);;
        printDice(n, curr+2, ans+2);;
        printDice(n, curr+3, ans+3);
        printDice(n, curr+4, ans+4);
        printDice(n, curr+5, ans+5);
        printDice(n, curr+6, ans+6);
    }

    
}
