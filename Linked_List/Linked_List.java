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
    private Node GetNode(int k) throws Exception{
        if(k<0||k>=size){
            throw new Exception("Exception here");
        }
        Node temp=head;
        for(int i=0;i<=k-1;i++){
            temp=temp.next;
        }

        return temp;

    }
    public void addAtIndex(int k,int item) throws Exception{
        if(k==0){
            addFirst(item);
        }
       else if(k==size){
            addLast(item);
        }
        else{
            Node k_1th=GetNode(k-1);
            Node nn=new Node();
            nn.val=item;
            nn.next=k_1th.next;
            k_1th.next=nn;
        }

    }
    public int getFirst(){
        return head.val;

    }
    public int getLast(){
        return tail.val;

    }
    public int getAtIndex(int k) throws Exception{
        return GetNode(k).val;

    }
    public void removefirst(){
        head=head.next;
    }
    public void Display(){
        Node temp=head;
        while (temp!=null) {
           System.out.print(temp.val+"->");
            temp=temp.next;
           
            
        }
    }


}
