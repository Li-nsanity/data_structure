package Recursion;

public class taijie {
    public static int getSum(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        // hasSolvedList可以理解成一个Map，key是n，value是f(n)
//        if (hasSolvedList.containsKey(n)) {
//            return hasSolvedList.get(n);
//        }
        int ret = getSum(n - 1) + getSum(n - 2);
//        hasSolvedList.push(n, ret);
        return ret;
    }

    public static void main(String[] args) {
        int n = 30;
        System.out.println("总共有："+getSum(n)+"种走法。");
    }
}
