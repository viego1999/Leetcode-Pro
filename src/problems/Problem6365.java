package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6365
 * @since 2023/2/19 10:33
 */
public class Problem6365 {
    public static void main(String[] args) {
        System.out.println(f(39));
        System.out.println(f(38));
        System.out.println(f(54));
        System.out.println(f(27));

        System.out.println(minOperations(39));
        System.out.println(minOperations(38));
        System.out.println(minOperations(54));
        System.out.println(minOperations(27));

        System.out.println(Integer.toBinaryString(39));
        System.out.println(Integer.toBinaryString(38));
        System.out.println(Integer.toBinaryString(54));
        System.out.println(Integer.toBinaryString(27));
    }

    public static int minOperations(int n) {
        int t = (int) (Math.log10(n) / Math.log10(2));
        int sub = Math.min(n - (1 << t), (1 << (t + 1)) - n);
        return sub == 0 ? 1 : minOperations(sub) + 1;
    }

    // 38 - 100110
    // 54 - 110110
    public static int f(int n) {
        int ans = 0;
        while (n > 0) {
            if ((n & 1) == 1) { // 奇数
                if ((n >> 1 & 1) == 1) n++; // 只要遇到连续的1就加1，例如（110 -> 1000）
                ans++;
            }
            n >>= 1;
        }
        return ans;
    }
}
