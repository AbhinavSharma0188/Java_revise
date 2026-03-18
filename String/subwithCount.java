public class subwithCount {
    static int count=0;
    public static void main(String[] args) {
        String s="abc";
        
        printSub(s,"");
        System.out.println(count);
    }
    public static void printSub(String s,String ans){
        if(s.length() == 0){
            System.out.print(ans+" ");
            count++;
           
            return;
        }
        char ch=s.charAt(0);
        printSub(s.substring(1),ans);
        printSub(s.substring(1),ans+ch);
    }
}
