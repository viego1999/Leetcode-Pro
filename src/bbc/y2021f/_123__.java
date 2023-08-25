package bbc.y2021f;

import java.util.Scanner;

public class _123__ {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            long l = scan.nextLong(), r = scan.nextLong();
            System.out.println(getSum(r) - getSum(l - 1));
        }
    }

    public static long getN(long x) { // 定位到 x 在那一块上
        return (long) Math.ceil(Math.sqrt(0.25 + 2 * x) - 0.5);
    }

    public static long getSum(long x) {
        long n = getN(x), t = x - n * (n - 1) / 2;
        // 1,3,6,... 的前n项和为： n*(n+1)*(n+2)/6 （这里也可以使用前缀和来记录）
        return n * (n - 1) * (n + 1) / 6 + t * (t + 1) / 2;
    }
}
