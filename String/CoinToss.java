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
    if(ans.length()==0 || ans.charAt(ans.length()-1)!='H'){
        printToss(n-1, ans+"H");

    }
    
    printToss(n-1, ans+"T");
}
    
}
