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
    public void push(int item){
        top++;
        arr[top]=item;

    }
    
}
