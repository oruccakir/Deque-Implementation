import javax.xml.crypto.Data;

public class SimpleDeque <T> implements DequeInterface<T>{

    private Object dequeArray[];

    private int size;
    private int capacity;
    private int rearIndex;

    public SimpleDeque (){

        capacity = 10;

        dequeArray = new Object[capacity];

        size = 0;

        rearIndex = -1;

    }

    @Override
    public void insertFront(T data) {

        if(isFull()){ System.out.println("Stack overflow error"); return;}

        if(rearIndex == -1){

            dequeArray[0] = data;

        }

        else{

            for(int i = rearIndex; i>=0; i--) dequeArray[i+1] = dequeArray[i];

            dequeArray[0] = data;

        }

        rearIndex++;

        size++;

    }

    @Override
    public void insertLast(T data) {

        if(isFull()){ System.out.println("Stack overflow error"); return;}

        rearIndex++;

        dequeArray[rearIndex] = data;

        size++;

    }

    @Override
    public void deleteFront() {

        if(isEmpty()) {System.out.println("Stack underflow error"); return;}

        dequeArray[0] = null;

        for(int i=0; i<rearIndex; i++) dequeArray[i] = dequeArray[i+1];

        rearIndex--;

        size--;

    }

    @Override
    public void deleteLast() {

        if(isEmpty()) {System.out.println("Stack underflow error"); return;}

        dequeArray[rearIndex] = null;

        rearIndex--;

        size--;

    }

    @Override
    public T getFront() {

        if(isEmpty()) {System.out.println("Stack underflow error"); return null;}

        return (T)dequeArray[0];
    }

    @Override
    public T getRear() {

        if(isEmpty()) {System.out.println("Stack underflow error"); return null;}

        return  (T)dequeArray[rearIndex];
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void print() {
        
        System.out.print("[ ");

        for(int i=0; i<=rearIndex; i++) System.out.print(dequeArray[i]+" ");

        System.out.println("]");
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {

        SimpleDeque<Integer> ld = new SimpleDeque<>();

        
        ld.insertFront(15);
        ld.insertFront(28);
        ld.insertFront(89);
        ld.insertLast(87);
        ld.deleteLast();
        ld.deleteFront();
        ld.deleteFront();
        //ld.deleteFront();


        ld.print();

        System.out.println("Front : "+ld.getFront()+" Rear : "+ld.getRear());
        System.out.println("Empty : "+ld.isEmpty()+" Full : "+ld.isFull());

    }
    
}
