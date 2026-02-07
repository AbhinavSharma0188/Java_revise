package Stack;
import java.util.Stack;

public class Stock_span {
    public static void main(String[] args) {
        int arr[]={3,1,6,4,18,7,5,11,19};
        Stack<Integer>st=new Stack<>();
        int ans[]=new int[arr.length];
        for(int i=0;i<=arr.length-1;i++){
            while(!st.isEmpty()&&arr[st.peek()]<=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=i+1;
            }
            else{
                ans[i]=i-st.peek();
            }
              st.push(i);
          
        }
        for(int i=0;i<=ans.length-1;i++){
            System.out.print(ans[i]+" ");
        }
        

    }
    
}
