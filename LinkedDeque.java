public class LinkedDeque <T> implements DequeInterface <T> {

    private Node head;
    private Node tail;
    private int size;

    private class Node{

        private Node next;
        private Node prev;
        private T data;

        public Node(T data){
            this.data = data;
            next = prev = null;
        }

    }

    public LinkedDeque(){

        head = tail = null;

        size = 0;

    }


    @Override
    public void insertFront(T data) {

        Node newNode = new Node(data);

        if(head == null){
            head = tail = newNode;
        }
        else{

            newNode.next = head;

            head.prev = newNode;

            head = newNode;

        }

        size++;
        
    }

    @Override
    public void insertLast(T data) {

        Node newNode = new Node(data);

        if(tail == null){
            tail = head = newNode;
        }
        else{

            newNode.prev = tail;

            tail.next = newNode;

            tail = newNode;

        }

        size++;
        
    }

    @Override
    public void deleteFront() {

        if(size == 0) { System.err.println("Stack underflow error"); return; }
        
        else if(size == 1)  head = tail = null;

        else{

            head.next.prev = null;
            
            head = head.next;

        }

        size--;

    }

    @Override
    public void deleteLast() {

        if(size == 0) { System.err.println("Stack underflow error"); return; }

        else if(size == 1)  head = tail = null;

        else{

            tail.prev.next = null;

            tail = tail.prev;

        }

        size--;

    }

    @Override
    public T getFront() {

        if(size == 0) { System.err.println("Stack underflow error"); return null; }

        return head.data;
        
    }

    @Override
    public T getRear() {

        if(size == 0) { System.err.println("Stack underflow error"); return null; }

        return tail.data;
        
    }

    @Override
    public boolean isFull() {

        return false;
        
    }

    @Override
    public boolean isEmpty() {

        return head == null && tail == null;
        
    }

    @Override
    public void print() {
        
        System.out.print("[ ");

        Node temp = head;

        while(temp != null){

            System.out.print(temp.data+" ");

            temp = temp.next;

        }

        System.out.println("]");

    }

    @Override
    public int size() {
        return size;
    }

    
    public static void main(String[] args) {
        
        LinkedDeque<Integer> ld = new LinkedDeque<>();

        ld.insertFront(15);
        ld.insertFront(28);
        ld.insertLast(89);
        ld.deleteFront();
        ld.deleteLast();
        ld.deleteLast();

        ld.print();

        System.out.println("Front : "+ld.getFront()+" Rear : "+ld.getRear());
        System.out.println("Empty : "+ld.isEmpty()+" Full : "+ld.isFull());

    }

    







}
