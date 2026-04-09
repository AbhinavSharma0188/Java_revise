package Queue;

public class Queue {
    private int arr[];
    private int front=0;
    private int size=arr.length-1;
    public Queue(){
        arr=new int[5];;


    }
    public  Queue(int n){
        arr=new int[n];
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean isFull(){
        return size==arr.length;
    }
    public void enque(int element) throws Exception{
        if(isFull()){
            throw new Exception("Queue is full");
        }
        arr[size]=element;
        size++;
       
    }
    public int deque(){
        int rev=arr[front];
        front++;
        size--;
        return rev;
       
        
    }

    
}
