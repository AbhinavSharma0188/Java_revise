

import java.util.Stack;

public class Insert_button_in_stack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        System.out.println(st);
        Insert_button(st, -9);
        System.out.println(st);
        
    }
    public static void Insert_button(Stack<Integer>st,int item){
        if(st.isEmpty()){
            st.push(item);
            return;
        }
       int ii= st.pop();
        Insert_button(st, item);
        st.push(ii);

    }
}
