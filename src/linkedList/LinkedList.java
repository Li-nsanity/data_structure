package linkedList;

public class LinkedList<E> {

    /**
     * addLast(e) O(n)
     * addFirst(e) O(1)
     * add(index,e) O(n)
     * removeLast(e) O(n)
     * removeFirst(e) O(1)
     * remove(index,e) O(n)
     * set(index,e) O(n)
     * get(index) O(n)
     * contains(e) O(n)
     */
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    // 初始化链表
    private Node dummyhead;
    private int size;

    // 构造函数（无参）
    public LinkedList() {
        dummyhead = new Node(null, null);
        size = 0;
    }
    // 传入一个数组，构造成链表

    // 获取链表中结点的个数
    public int getSize() {
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表头插入节点
    public void addFrist(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
//        head = new Node(e, head);
//        size++;
        add(0, e);
    }

    // 在链表中的Index（0-Based）位置添加新的元素e，不是常用操作，练习用
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add Failed,Illegal index.");
        }
        Node prev = dummyhead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//      Node node = new Node(e);
//      node.next = prev.next;
//      prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;
    }

    // 在链表末尾添加新的元素
    public void addLast(E e) {
//        Node prev = head;
//        for (int i = 0; i < size-1; i++) {
//            prev = prev.next;
//        }
//        Node node = new Node(e);
//        node.next = null;
//        prev.next = node;
//        size++;
        add(size, e);
    }

    // 获取链表中的Index（0-Based）位置的元素，不是常用操作，练习用
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get Failed,Illegal index.");
        }
        Node cur = dummyhead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    // 获取链表第一个元素
    public E getFrist() {
        return get(0);
    }

    // 获取链表最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 修改链表中的Index（0-Based）位置的元素，不是常用操作，练习用
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get Failed,Illegal index.");
        }
        Node cur = dummyhead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    // 查找链表中是否有元素e
    public boolean contains(E e) {
        Node cur = dummyhead.next;
//        for (int i = 0; i < size; i++) {
//            E temp = cur.e;
//            if(temp.equals(e)){
//                return true;
//            }
//            cur = cur.next;
//        }
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // 删除链表中的Index（0-Based）位置的元素，不是常用操作，练习用
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add Failed,Illegal index.");
        }
        Node prev = dummyhead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    // 从链表中删除第一个元素，并返回元素的值
    public E removeFirst() {
        return remove(0);
    }

    // 从链表中删除最后一个元素，并返回元素的值
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyhead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
//        for (Node cur = dummyhead.next; cur != null; cur = cur.next)
        res.append("Null");
        return res.toString();
    }
}
