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
    public void addAtIndex(int idx,int item){
        if(idx==0){
            addFirst(item);
            return;
        }
        if(idx==size){
            addLast(item);
            return;
        }
        Node nn=new Node();
        nn.val=item;
        Node temp=getnode(idx-1);
        nn.next=temp.next;
        temp.next=nn;
        size++;
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
    public int getFirst(){
        if(size==0){
            throw new IndexOutOfBoundsException();
        }
        return head.val;
    }
    public int getLast(){
        if(size==0){
            throw new IndexOutOfBoundsException();
        }
        return tail.val;
    }
    public int getAtIndex(int idx){
        if(idx<0||idx>=size){
            throw new IndexOutOfBoundsException();
        }
        Node temp=getnode(idx);
        return temp.val;
    }
    public int removeFirst(){
        if(size==0){
            throw new IndexOutOfBoundsException();
        }
        int val=head.val;
        head=head.next;
        size--;
        return val;
    }
    public int removeLast(){
        if(size==0){
            throw new IndexOutOfBoundsException();
        }
        int val=tail.val;
        Node temp=getnode(size-2);
        temp.next=null;
        tail=temp;
        size--;
        return val;
    }
    public int removeAtIndex(int idx){
        if(idx<0||idx>=size){
            throw new IndexOutOfBoundsException();
        }
        if(idx==0){
            return removeFirst();
        }
        if(idx==size-1){
            return removeLast();
        }
        Node temp=getnode(idx-1);
        int val=temp.next.val;
        temp.next=temp.next.next;
        size--;
        return val;
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