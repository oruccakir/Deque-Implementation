import java.util.Arrays;

public class Deque <T> implements DequeInterface<T> {

    private int size;
    private int frontIndex;
    private int rearIndex;
    private int capacity;
    private Object[] dequeArray;

    public Deque (){

        capacity = 10;
        size = 0;
        frontIndex = -1;
        rearIndex = -1;

        dequeArray = new Object[capacity];

    }

    public Deque (int capacity){

        this.capacity = capacity;
        size = 0;
        frontIndex = -1;
        rearIndex = -1;

        dequeArray = new Object[capacity];

    }

    @Override
    public void insertFront(T data) {

        if(isFull()){ System.out.println("Stack overflow error"); return;}

        if(frontIndex == -1){

            rearIndex = 0;

            frontIndex = 0;

            dequeArray[frontIndex] = data;

        }
        else{

            frontIndex = ( frontIndex - 1 + capacity ) % capacity;

            dequeArray[frontIndex] = data;

        }

        size++;

    }

    @Override
    public void insertLast(T data) {

        if(isFull()){ System.out.println("Stack overflow error"); return;}

        rearIndex = (rearIndex + 1 ) % capacity;

        if(frontIndex == -1) frontIndex = rearIndex;

        dequeArray[rearIndex] = data;

        size++;

    }

    @Override
    public void deleteFront() {

        if(isEmpty()) {System.out.println("Stack underflow error"); return;}

        dequeArray[frontIndex] = null;

        frontIndex = (frontIndex + 1 ) % capacity;

        size--;

    }

    @Override
    public void deleteLast() {
        
        if(isEmpty()) {System.out.println("Stack underflow error"); return;}

        dequeArray[rearIndex] = null;

        rearIndex = (rearIndex - 1 + capacity) % capacity;
        
        size--;

    }

    @Override
    public T getFront() {
        
        if(isEmpty()) {System.out.println("Stack underflow error"); return null;}

        return (T)dequeArray[frontIndex];
    }

    @Override
    public T getRear() {
        
        if(isEmpty()) {System.out.println("Stack underflow error"); return null;}

        return (T)dequeArray[rearIndex];
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
        System.out.println(Arrays.toString(dequeArray));
    }

    @Override
    public int size() {
        return size;
    }


    public static void main(String[] args) {
        
        Deque <Integer> ld = new Deque<>(10);

        ld.insertFront(15);
        ld.insertLast(16);
        ld.insertFront(89);
        ld.insertLast(78);
        ld.deleteFront();
        ld.insertLast(12);
        ld.insertFront(87);
        ld.insertFront(45);
        ld.insertFront(71);
        ld.deleteLast();



        ld.print();

        System.out.println("Front : "+ld.getFront()+" Rear : "+ld.getRear());
        System.out.println("Empty : "+ld.isEmpty()+" Full : "+ld.isFull());


    }
    
}
