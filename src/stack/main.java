package stack;

import java.util.Random;

public class main {
    public static void main(String[] args) {

//        ArrayStack<Integer> aStack = new ArrayStack<>();
//        for (int i = 0; i < 5; i++) {
//            aStack.push(i);
//            System.out.println(aStack);
//        }
//        aStack.pop();
//        System.out.println(aStack);
//        System.out.println(aStack.peek());
//        String s = "(]";
//        Solution suo = new Solution();
//        System.out.println(suo.isVaild(s));

//        LinkedListStack<Integer> lStack = new LinkedListStack<>();
//        for (int i = 0; i < 5; i++) {
//            lStack.push(i);
//            System.out.println(lStack);
//        }
//        lStack.pop();
//        System.out.println(lStack);
        int opCount = 10000000;
        ArrayStack<Integer> aStack = new ArrayStack<>();
        double time1 = testStack(aStack, opCount);
        System.out.println("ArrayStack,Time:" + time1 + "s");

        LinkedListStack<Integer> lStack = new LinkedListStack<>();
        double time2 = testStack(lStack, opCount);
        System.out.println("LinkedlistStack,Time:" + time2 + "s");
    }

    // 测试Stack运行opCount个push和pop操作所需要的时间，单位：秒
    private static double testStack(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
