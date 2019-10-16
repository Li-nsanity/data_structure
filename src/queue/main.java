package queue;

public class main {
    public static void main(String[] args) {
//      ArrayQueue<Integer> aqueue = new ArrayQueue<>(20);
        LoopQueue<Integer> aqueue = new LoopQueue<>(20);
        for (int i = 0; i < 12; i++) {
            aqueue.enqueue(i);
            System.out.println(aqueue);
            //每进入队列三个元素出队列一个元素
            if(i % 3 == 2){
                aqueue.dequeue();
                System.out.println(aqueue);
            }
        }
        System.out.println("队首元素"+aqueue.getFront());
        System.out.println("队列容量"+aqueue.getCapacity());
    }
}
