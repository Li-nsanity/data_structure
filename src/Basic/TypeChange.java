package Basic;

import java.util.Random;
import java.util.Scanner;

public class TypeChange {
    public static void main(String[] args) {
//        short a = 8;
//        int b = a + 3;
//        float c = 11.5F;
//        int d = (int) (c - 2);
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(d);
//        int YM = 176;
//        int LSS = 175;
//        int LYF = 178;
//        int top = YM > LSS ? YM : LSS;
//        int res = top > LYF ? top : LYF;
//        System.out.println(res);
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入数字：");
//        int x = sc.nextInt();
//        System.out.println(x);
//        int count = 0;
//        for(int i = 100;i < 1000;i++){
//            int first = i%10;
//            int second = i/10%10;
//            int third = i/100%10;
//            if(first*first*first+second*second*second+third*third*third == i){
//                System.out.println(i+"为水仙花数");
//                count++;
//            }
//        }
//        System.out.println("水仙花数一共有："+count+"个");
        Random rd = new Random();
        int num = rd.nextInt(100)+1;
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("在1-100之间猜数字");
            int gessnum = sc.nextInt();
            if(gessnum > num){
                System.out.println("你猜的数字大了");
            }else if(gessnum < num){
                System.out.println("你猜的数字小了");
            }else{
                System.out.println("恭喜你猜中了");
                break;
            }
        }
    }
}
