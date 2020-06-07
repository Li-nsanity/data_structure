package Tree;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] numbers = {5, 3, 6, 8, 4, 2};
        for (int i : numbers) {
            bst.add(i);
        }
        System.out.println(bst.size());
        System.out.println(bst.contains(5));
        System.out.println(bst.contains(1));
        bst.preOrder();
    }

}
