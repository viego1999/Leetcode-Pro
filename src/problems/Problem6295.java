package problems;

import java.util.*;

public class Problem6295 {
    public static void main(String[] args) {
        System.out.println(minimizeSet(2, 7, 1, 3));
        System.out.println(minimizeSet(3, 5, 2, 1));
        System.out.println(minimizeSet(2, 4, 8, 2));
        System.out.println(minimizeSet(47911, 14723, 18200983, 23172743));
    }

    public static int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int n = uniqueCnt1 + uniqueCnt2;
        long d = (long) divisor1 / gcd(divisor1, divisor2) * divisor2;
        long l = 1, r = (int) 2e9;
        while (l < r) {
            long m = l + r >> 1;
            long i = m - m / divisor1, j = m - m / divisor2, s = m - m / divisor1  - m / divisor2 + m / d;
            if (i + j - s < n || i < uniqueCnt1 || j < uniqueCnt2) l = m + 1;
            else r = m;
        }
        return (int) l;
    }

    public static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    public static int minimizeSet_(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int n = uniqueCnt1 + uniqueCnt2, k = 0, t = 1;
        BitSet bs = new BitSet(), bs1 = new BitSet(), bs2 = new BitSet();
        while (k < n) {
            if (t % divisor1 != 0 && t % divisor2 != 0) {
                k++;
                bs.set(t);
            }
            if (t % divisor1 != 0) bs1.set(t);
            if (t % divisor2 != 0) bs2.set(t);
            t++;
        }
        int[] sums = new int[t + 1], sums1 = new int[t + 1], sums2 = new int[t + 1];
        for (int i = 1; i <= t; i++) {
            sums[i] = sums[i - 1] + (bs.get(i) ? 1 : 0);
            sums1[i] = sums1[i - 1] + (bs1.get(i) ? 1 : 0);
            sums2[i] = sums2[i - 1] + (bs2.get(i) ? 1 : 0);
        }
        int l = 0, r = t;
        while (l < r) {
            int m = l + r >> 1;
            int i = sums1[m], j = sums2[m], s = sums[m];
            if (i + j - s < n || i < uniqueCnt1 || j < uniqueCnt2) l = m + 1;
            else r = m;
        }
        return l;
    }
}
