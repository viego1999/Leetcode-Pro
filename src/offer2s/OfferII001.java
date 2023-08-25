package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII001
 * @since 2023/3/4 21:05
 */
public class OfferII001 {
    public static void main(String[] args) {

    }

    public int divide(int a, int b) {
        if (a == 0) return 0;
        if (b == 1) return a;
        if (a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;
        boolean negative = (a > 0 && b < 0) || (a < 0 && b > 0);
        long A = Math.abs((long) a), B = Math.abs((long) b);
        return negative ? -1 * (int) calculate(A, B) : (int) calculate(A, B);
    }

    public long calculate(long a, long b) {
        if (a < b) return 0;
        long cnt = 1, temp = b;
        while (a >= (temp << 1)) {
            cnt <<= 1;
            temp <<= 1;
        }
        return cnt + calculate(a - temp, b);
    }
}
