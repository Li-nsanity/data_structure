package stack;

public class main {
    public static void main(String[] args) {
        ArrayStack<Integer> aStack = new ArrayStack<>();
        for(int i=0;i<5;i++){
            aStack.push(i);
            System.out.println(aStack);
        }
        aStack.pop();
        System.out.println(aStack);
        System.out.println(aStack.peek());
    }
}
