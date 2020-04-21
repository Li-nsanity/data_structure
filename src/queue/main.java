package queue;

import java.util.Random;
import java.util.function.DoubleToIntFunction;

public class main {
    public static void main(String[] args) {
        //数组队列和循环队列的测试用例
        /*ArrayQueue<Integer> aqueue = new ArrayQueue<>(20);
        LoopQueue<Integer> aqueue = new LoopQueue<>(10);
        for (int i = 0; i < 10; i++) {
            aqueue.enqueue(i);
            System.out.println(aqueue);
            //每进入队列三个元素出队列一个元素
            if (i % 3 == 2) {
                aqueue.dequeue();
                System.out.println(aqueue);
            }
        }
        System.out.println("队首元素" + aqueue.getFront());
        System.out.println("队列容量" + aqueue.getCapacity());*/
        //######################################################

        //数组队列，循环队列，链表队列的算法对比
        int opCount = 100000;
        ArrayQueue<Integer> aqueue = new ArrayQueue<>();
        double testTime1 = testQueue(aqueue, opCount);
        System.out.println("ArrayQueue Time:" + testTime1 + " s");

        LoopQueue<Integer> lqueue = new LoopQueue<>();
        double testTime2 = testQueue(lqueue, opCount);
        System.out.println("LoopQueue Time:" + testTime2 + " s");

        LinkedListQueue<Integer> llqueue = new LinkedListQueue<>();
        double testTime3 = testQueue(llqueue, opCount);
        System.out.println("LinkedListQueue Time:" + testTime3 + " s");
        // 基于链表的队列
//        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
//        for (int i = 0; i < 10; i++) {
//            linkedListQueue.enqueue(i);
//            System.out.println(linkedListQueue);
//            if (i % 3 == 2) {
//                linkedListQueue.dequeue();
//                System.out.println(linkedListQueue);
//            }
//        }
    }

    //测试使用q运行opCount = 100000个enqueue和dequeue所用的时间，单位：秒
    private static double testQueue(Queue<Integer> q, int opCount) {
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int j = 0; j < opCount; j++) {
            q.dequeue();
        }
        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }
}
