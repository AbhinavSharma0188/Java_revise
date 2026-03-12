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
    public void Display(){
        Node temp=head;

        while(temp!=null){
            System.out.println(temp.val);
            temp=temp.next;
        }
    }
    public static void main(String[] args) {
        Linked_List l1=new Linked_List();
        l1.addFirst(10);
        l1.addFirst(20);
        l1.addFirst(30);
        l1.Display();
        
        


        
    }

    
}