public interface DequeInterface <T> {

    public void insertFront(T data);

    public void insertLast(T data);

    public void deleteFront();

    public void deleteLast();

    public T getFront();
    
    public T getRear();

    public boolean isFull();

    public boolean isEmpty();

    public void print();

    public int size();
    
}
