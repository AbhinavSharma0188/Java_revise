public class Linked_List {
    public class Node {
        int val;
        Node next;

    
        
    }
    private Node head;
    private int size;
    private Node tail;
    public  void addFirst(int item){
        if(size==0){
            Node nn=new Node();
            nn.val=item;
            nn.next=null;
            head=nn;
            tail=nn;
            

        }
    }
    public static void main(String[] args) {
        Linked_List l1=new Linked_List();
        l1.addFirst(10);
        System.out.println(l1.head.val);


        
    }

    
}