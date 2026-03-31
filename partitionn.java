public class partitionn {
    public static void main(String[] args) {
        String ques="nitin";
        partitionnn(ques,"");
    }
    public static void partitionnn(String ques,String ans){
        if(ques.length()==0){
            System.out.println(ans);;
            return;
        
        }
        for(int i=0;i<=ques.length()-1;i++){
            String s=ques.substring(0,i+1);
            if(isPalindrome(s)){
            partitionnn(ques.substring(i+1), ans+s+"|");}
        }
    }
    public static boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    
}