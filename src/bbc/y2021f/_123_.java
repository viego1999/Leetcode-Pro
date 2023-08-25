package bbc.y2021f;

import java.util.Scanner;

public class _123_ {
    static long[] sums;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        sums = new long[2000005];
        long j = 0;
        for (int i = 1; i < sums.length; i++) {
            j += i;
            sums[i] = sums[i - 1] + j;
        }
        while (t-- > 0) {
            long x1 = scan.nextLong(), x2 = scan.nextLong();
            System.out.println(getSum(x2) - getSum(x1 - 1));
        }
    }

    public static long getSum(long x) {
        int l = 1, r = 2000005;
        while (l < r) {
            int mid = l + r >> 1;
            if (f(mid) < x) l = mid + 1; // f(mid)表示个数1~mid个
            else r = mid;
        }
        // 求前面一块
        x -= f(--l);
        return sums[l] + f(x);
    }

    public static long f(long x) {
        return (1 + x) * x / 2;
    }
}
