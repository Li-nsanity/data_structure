package array;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<Integer>(20);
        for(int i = 0;i<=10;i++){
            arr.addLast(i);
        }
        arr.set(3,2);
        arr.reverse();
        System.out.println(arr);
        arr.addLast(5);
        System.out.println(arr);
        /*System.out.println(arr);
        arr.addpro(3,666);
        System.out.println(arr);
        System.out.println(arr.getIndex(11));*/
        /*ArrayList<Integer> allIndex = arr.findAllIndex(2);
        for (Integer index : allIndex) {
            System.out.println(index);
        }
        arr.removeAllElm(2);
        System.out.println(arr);*/
        /*arr.add(5,100);
        arr.addFrist(-1);
        System.out.println(arr);*/
    }
}
