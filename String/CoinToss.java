public class CoinToss {
    public static void main(String[] args) {
        int n=3;
        printToss(n,"");
    }
public static void printToss(int n,String ans){
    if(n==0){
        System.out.println(ans);
        return;
    }
    printToss(n-1, ans+"H");
    printToss(n-1, ans+"T");
}
    
}
