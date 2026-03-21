public class sub {
    public static void main(String[] args) {
        String s="abc";
        
        printSub(s,"");
    }
    public static void printSub(String s,String ans){
        if(s.length() == 0){
            System.out.print(ans+" ");
            return;;
        }
        char ch=s.charAt(0);
        printSub(s.substring(1),ans);
        printSub(s.substring(1),ans+ch);
    }
}
