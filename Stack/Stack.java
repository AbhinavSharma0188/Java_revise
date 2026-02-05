package Stack;

public class Stack {
    private int arr[];
    private int top=-1;
    public Stack(){
        arr=new int [5];


    }
    public Stack(int n){
        arr=new int[n];

    }
    public boolean isEmpty(){
        return top==-1;

    }
    public boolean isFull(){
        return top==arr.length-1;
    }
    public void push(int item) throws Exception{
        if(isFull()){
            throw new Exception("Stack is full");
        }
        top++;
        arr[top]=item;

    }
    public int pop(){
        int rem=arr[top];
        top--;
        return rem;
    }
    public int peek(){
        int rem=arr[top];
        return rem;
    }
    public int size(){
        return top+1;
    }
    
}
