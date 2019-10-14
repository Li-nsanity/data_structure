package array;

import java.util.ArrayList;

/**
 * addLast O(1)
 * addFirst O(n)
 * add(int index,int e) O(n/2)
 * resize 最坏O(n) 均摊 假设capacity = n,进行n+1次的addLast操作，总共进行2N+1次基本操作，每次addLast操作，进行两次基本操作
 * removeLast O(1)
 * removeFirst O(n)
 * removeIndex O(n/2)
 * setindex O(1) 支持随机访问
 * get(index) O(1)
 * findIndex(e) O(n)
 * contains(e) O(n)
 * 复杂度震荡
 * 不断地addLast 和 removeLast 操作 会导致复杂度震荡到O(n)
 * 产生原因:removeLast时 resize 过于着急
 * 解决方案:使resize变得lazy,当size == capacity /4 时，再将capacity减半
 *
 * @param <E>
 */
public class Array<E> {
    private E[] data;
    private int size;

    //构造函数，传入数组的容量capacity构造Array
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    //无参数的构造函数，默认容量是capacity = 10
    public Array(){
        this(10);
    }

    //获取数组中的元素个数
    public int getSize(){
        return size;
    }

    //获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //向数组Last添加元素
    public void addLast(E e){
       add(size,e);
    }

    //向数组Frist的位置添加元素
    public void addFrist(E e){
        add(0,e);
    }

    //在Index的位置插入一个元素e
    public void add(int index,E e){
        if(index < 0 || index >size){
            throw new IllegalArgumentException("AddList failed.Require Index >=0 And Index <= size");
        }
        if(size == data.length){
           resize(2*data.length);
        }
        for(int i = size-1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //获取index位置的元素
    public E getIndex(int index){
        if(index < 0 || index >=size){
            throw new IllegalArgumentException("GetIndex failed . Index is illegal.");
        }
        return data[index];
    }

    //修改索引index的位置的元素为e
    public void set(int index ,E e){
        if(index < 0 || index >size){
            throw new IllegalArgumentException("GetIndex failed . Index is illegal.");
        }
        data[index] = e;
    }

    //查询数组中是否包含元素e
    public boolean contains(E e){
        for (int i =0;i<size;i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    //查找数组中元素e对应的索引,如果不存在e，则返回-1
    public int findIndex(E e){
        for (int i =0;i<size;i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    //查找数组中元素e对应的所有索引
    public ArrayList<Integer> findAllIndex(E e){
        ArrayList<Integer> ary = new ArrayList<>();
        for (int i=0;i<size;i++){
            if(data[i].equals(e)){
                ary.add(i);
            }
        }
        return ary ;
    }

    //移除某个索引位置的元素,并返回删除的元素
    public E remove(int index){
        if(index < 0 || index >size){
            throw new IllegalArgumentException("GetIndex failed . Index is illegal.");
        }
        E res = data[index];
        for(int i = index;i+1<size;i++){
            data[i] =data[i+1];
        }
        size--;
        data[size] = null;//loitering objects != memory leak
        if(size == data.length/4 && data.length != 0){
            resize(data.length/2);
        }
        return res;
    }

    //从数组删除第一个元素
    public void removeFirst(){
        remove(0);
    }

    //从数组删除最后一个元素
    public void removeLast(){
        remove(size-1);
    }

    //从数组中删除指定的元素
    public void removeElm(E e){
        int ind = findIndex(e);
        if(ind != -1) {
            remove(ind);
        }
    }

    //从数组中删除指定的的所有元素
    public void removeAllElm(E e){
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2 = findAllIndex(e);
        System.out.println(arr2);
        int flag = arr2.size();
        System.out.println(flag);
        while(flag != 0){
            int index = findIndex(e);
            remove(index);
            flag--;
        }
    }
    //从数组中删除指定的的所有元素-改进
    public void removeAllElmPro(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                data[i]=null;
            }
        }
    }
    //求出数组的最大值 E extends Comparable

    //求出数组的最小值 E extends Comparable

    //数组反转
    public void reverse(){
        for(int min =0 , max =size-1;min<max;min++,max--){
            E temp = data[max];
            data[max] = data[min];
            data[min] = temp;
        }
    }
    //插入操作修改-直接将第K位的元素移动到数组最后
    public void addpro(int index,E e){
        if(index <0 && index >size){
            throw new IllegalArgumentException("GetIndex failed . Index is illegal.");
        }
        data[size] = data[index];
        data[index] = e;
        size++;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array : size = %d , capacity = %d\n",size,data.length));
        res.append("[");
        for(int i = 0;i<size;i++){
            res.append(data[i]);
            if(i != size-1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

    //数组扩容
    private void resize(int newCapacity){
        E[] newdata = (E[]) new Object[newCapacity];
        for (int i =0;i<size;i++){
            newdata[i] =data[i];
        }
        data = newdata;
    }
}
