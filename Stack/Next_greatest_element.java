
import java.util.Stack;


public class Next_greatest_element {
   public static void main(String[] args) {
     int arr[]={11,9,13,21,3};
    int ans[]=new int[arr.length];
    Stack<Integer>st=new Stack<>();
    for(int i=0;i<=arr.length-1;i++){
         while(!st.isEmpty() && arr[st.peek()]<arr[i]){
        ans[st.pop()]=arr[i];
    }
    st.push(i);
    }
   
    while(!st.isEmpty()){
        ans[st.pop()]=-1;
    }
  for(int i=0;i<=ans.length-1;i++){
    System.out.println(ans[i]);
  }
   }
   

    
}
