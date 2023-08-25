package bbc.y2021f;

import java.util.Scanner;

/**
 * 题目 2613: 蓝桥杯2021年第十二届国赛真题-异或变换
 * <p>
 * 时间限制: 1Sec 内存限制: 128MB 提交: 1133 解决: 218
 * <p>
 * 题目描述
 * <p>
 * 小蓝有一个 01 串 s = s1 s2 s3 · · · sn。
 * <p>
 * 以后每个时刻，小蓝要对这个 01 串进行一次变换。每次变换的规则相同。
 * <p>
 * 对于 01 串 s = s1 s2 s3 · · · sn，变换后的 01 串 s′ = s′1 s′2 s′3· · · s′n 为：
 * <p>
 * s′1 = s1;
 * <p>
 * s′i = s{i-1} ⊕ si。
 * <p>
 * 其中 a ⊕ b 表示两个二进制的异或，当 a 和 b 相同时结果为 0，当 a 和 b不同时结果为 1。
 * <p>
 * 请问，经过 t 次变换后的 01 串是什么？
 * <p>
 * 输入
 * <p>
 * 输入的第一行包含两个整数 n, t，分别表示 01 串的长度和变换的次数。
 * <p>
 * 第二行包含一个长度为 n 的 01 串。
 * <p>
 * 输出
 * <p>
 * 输出一行包含一个 01 串，为变换后的串。
 * <p>
 * 样例输入
 * <p>
 * 5 3
 * <p>
 * 10110
 * <p>
 * 样例输出
 * <p>
 * 11010
 * <p>
 * 提示
 * <p>
 * 【样例说明】
 * <p>
 * 初始时为 10110，变换 1 次后变为 11101，变换 2 次后变为 10011，变换 3 次后变为 11010。
 * <p>
 * 【评测用例规模与约定】
 * <p>
 * 对于 40% 的评测用例，1 ≤ n ≤ 100, 1 ≤ t ≤ 1000。
 * <p>
 * 对于 80% 的评测用例，1 ≤ n ≤ 1000, 1 ≤ t ≤ 109。
 * <p>
 * 对于所有评测用例，1 ≤ n ≤ 10000, 1 ≤ t ≤ 1018。
 */
public class XORTransformer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong(), m = scan.nextLong();
        StringBuilder sb = new StringBuilder(scan.next());
        // 找规律，循环，2的某次方。1小于等于2的0次方，即2的0次方；2小于等于2的1次方，即2的1次方；3和4则为2的2次方；5到8则为2的3次方。。。
        int t = log2(n);
        t = Math.pow(2, t) == m ? t : t + 1;
        long mod = (long) Math.pow(2, t);
        m %= mod;
        while (m-- > 0) {
            String temp = "0" + sb.substring(0, sb.length() - 1);
            for (int i = 0; i < n; i++) {
                sb.setCharAt(i, (char) ((sb.charAt(i) ^ temp.charAt(i)) + '0'));
            }
        }
        System.out.println(sb);
    }

    public static int log2(long n) {
        return (int) (Math.log(n) / Math.log(2));
    }
}
