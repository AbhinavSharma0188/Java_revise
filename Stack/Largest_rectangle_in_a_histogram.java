import java.util.Stack;

public class Largest_rectangle_in_a_histogram {
    public static void main(String[] args) {
        int arr[]={2,1,5,6,2,3};
        System.out.println(LargestRect(arr));
    }

    public static int LargestRect(int arr[]){
        Stack<Integer> st=new Stack<>();
        int ans=0;

        for(int i=0;i<arr.length;i++){

            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                int height = arr[st.pop()];
                int right = i;

                if(st.isEmpty()){
                    int area = height * right;
                    ans = Math.max(area, ans);
                }
                else{
                    int left = st.peek();
                    int area = height * (right - left - 1);
                    ans = Math.max(area, ans);
                }
            }

            st.push(i);
        }

        // Final remaining stack processing
        int right = arr.length;
        while(!st.isEmpty()){
            int height = arr[st.pop()];

            if(st.isEmpty()){
                int area = height * right;
                ans = Math.max(area, ans);
            }
            else{
                int left = st.peek();
                int area = height * (right - left - 1);
                ans = Math.max(area, ans);
            }
        }

        return ans;
    }
}
