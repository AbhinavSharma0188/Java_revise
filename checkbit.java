public class checkbit {

    public static void main(String[] args) {
        int n=8;
       int pos=2;
      System.out.println( checkbitt(n,pos));

    }
    public static boolean checkbitt(int n,int pos){
       int data=(n)>>(pos-1);
       if((data&1)==0){
       return true;
       }
       return false;
    }
}