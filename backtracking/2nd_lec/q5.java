import java.util.ArrayList;
import java.util.List;

public class q5 {
    public static void main(String[] args) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> current=new ArrayList<>();

        int n=4;
        int k=2;
        int start=1;
        backtrack(start,n,k,current,result);
        System.out.println(result);
        
    }
    public static void backtrack(int start,int n,int k,List<Integer>current,List<List<Integer>>result){
        if(k==0){
            result.add(new ArrayList<>(current));
            return;

        }
        for(int i=start;i<=n;i++){
            current.add(i);
            backtrack(i+1,n,k-1,current,result);
            current.remove(current.size()-1);
        }
    }
    
}
