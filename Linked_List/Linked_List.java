public class Linked_List {
    public class Node {
        int val;
        Node next;

    
        
    }
    private Node head;
    private int size;
    private Node tail;
    public  void addFirst(int item){
         Node nn=new Node();
            nn.val=item;
        if(size==0){
           
            nn.next=null;
            head=nn;
            tail=nn;
size++;
            

        }
        else{
            nn.next=head;
            head=nn;
size++;
        }
    }
    private Node getnode(int k){
        if(k<0||k>=size){
            throw new IndexOutOfBoundsException();
        }
        Node temp=head;
        for(int i=0;i<k;i++){
            temp=temp.next;
        }
        return temp;
        
    }
    public void Display(){
        Node temp=head;

        while(temp!=null){
            System.out.println(temp.val);
            temp=temp.next;
        }
    }
    public void addLast(int item){
        Node nn=new Node();
        nn.val=item;
        if(size==0){
            nn.next=null;
            head=nn;
            tail=nn;
            size++;
        }
        else{
            tail.next=nn;
            tail=nn;
            size++;
        }
    }
    public static void main(String[] args) {
        Linked_List l1=new Linked_List();
        l1.addFirst(10);
        l1.addFirst(20);
        l1.addFirst(30);
        l1.addLast(40);
        l1.Display();
        
        


        
    }

    
}