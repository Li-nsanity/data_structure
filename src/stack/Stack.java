package stack;

/**
 * int getsize(); O(1)
 * boolean isEmpty(); O(1)
 * void push(E e); O(1)
 * E pop(); O(1)
 * E peek(); O(1)
 *
 * @param <E>
 */
public interface Stack<E> {

    int getsize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
