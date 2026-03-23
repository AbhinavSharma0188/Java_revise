public class gp {

    public static void main(String[] args) {
        generate(0,0,"",3);
        
    }
    public static void generate(int open,int close,String ans,int n){
        if(open==n&&close==n){
            System.out.print(ans+" ");
        }
        if(open<n){
            generate(open+1, close, ans+"(", n);
        }
        if(close<open){
            generate(open, close+1, ans+")", n);
        }
    }
        
    
}