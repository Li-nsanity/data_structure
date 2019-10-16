package queue;

/**
 void enqueue(E e); O(1) 均摊
 E dequeue();  O(n)
 E getFront(); O(1)
 int getSize(); O(1)
 boolean isEmpty(); O(1)
 * @param <E>
 */
public interface Queue <E>{

    void enqueue(E e);
    E dequeue();
    E getFront();
    int getSize();
    boolean isEmpty();
}
