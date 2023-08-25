package problems;

import java.util.BitSet;

public class Problem1780 {
    public static void main(String[] args) {
//        System.out.println(checkPowersOfThree(6574365));
//        System.out.println(checkPowersOfThree(4));
        System.out.println(checkPowersOfFour(3));
        System.out.println(checkPowersOfFour(4));
        System.out.println(checkPowersOfFour(5));
        System.out.println(checkPowersOfFour(17));
    }

    public static boolean checkPowersOfFour(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            if (n % 4 >= 2) return false;
            sb.append(n % 4);
            n /= 4;
        }
        System.out.println(sb.reverse());
        return true;
    }

    // 判断三进制数
    public static boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) return false;
            n /= 3;
            System.out.println(n);
        }
        return true;
    }

    public static boolean checkPowersOfThree_(int n) {
        BitSet bs = new BitSet();
        while (n > 0) {
            int t = log(3, n);
            if (bs.get(t)) return false;
            bs.set(t);
            n -= Math.pow(3, t);
        }
        return true;
    }

    public static int log(int a, int b) {
        return (int) (Math.log10(b) / Math.log10(a));
    }
}
