package Linked_List;

public class Linked_List {
    public class Node{
        int val;
        Node next;


    }
    private Node head;//first node 
    private int size;
    private Node tail;//last node 
    public void addFirst(int item){
        Node nn=new Node();
        nn.val=item;
        if(size==0){
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
    public void addLast(int item){
        if(size==0){
            addFirst(item);
        }
        else{
            Node nn=new Node();
            nn.val=item;
            tail.next=nn;
            tail=nn;
            size++;
        }
    }
    public void Display(){
        Node temp=head;
        while (temp!=null) {
           System.out.print(temp.val+"->");
            temp=temp.next;
           
            
        }
    }


}
