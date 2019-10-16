package queue;

public class main {
    public static void main(String[] args) {
        ArrayQueue<Integer> aqueue = new ArrayQueue<>(20);
        for (int i = 0; i < 12; i++) {
            aqueue.enqueue(i);
        }
        aqueue.dequeue();
        System.out.println(aqueue);
        System.out.println(aqueue.getFront());
        System.out.println(aqueue.capacity());
    }
}
