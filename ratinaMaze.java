public class ratinaMaze {
    public static void main(String[] args) {
        int m=3;
        int n=3;
        rat(0,0,m-1,n-1," ");
    }
    public static void rat(int cr,int cc,int er,int ec,String ans){
        if(cr>er||cc>ec){
            return;
        }
        if(cr==er&&cc==ec){
            System.out.println(ans);
            return;
        }
        rat(cr+1,cc,er,ec,ans+"D");
        rat(cr,cc+1,er,ec,ans+"R");
    }

    
}