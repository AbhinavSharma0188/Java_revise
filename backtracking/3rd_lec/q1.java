

public class q1 {
    public static void main(String[] args) {
        String ques="nitin";
        backtracking(ques,"");
        
    }
    public static void backtracking(String ques,String ans){
        
            if(ques.length()==0){
                System.out.println(ans);
                return;
            

        }

        for(int i=1;i<=ques.length();i++){
            String s=ques.substring(0, i);
            backtracking(ques.substring(i), ans+s+"|");
        }
    }
    
}
