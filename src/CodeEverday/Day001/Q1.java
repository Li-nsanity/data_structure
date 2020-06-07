package CodeEverday.Day001;

public class Q1 {
    /**
     * 13195的所有质因数为5,7,13和29。600851475143最大的质因数是多少？
     */
    public static long getMaxPrimeFactor(long n) {
        long i, ans = 0;
        for (i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                ans = i;
                n /= i;
            }



        }
        if (n > 1) {
            ans = n;
        }
        return ans;
    }

    public static void main(String[] args) {
        long n = 600851475143L;
        System.out.println(getMaxPrimeFactor(n));
    }
}
