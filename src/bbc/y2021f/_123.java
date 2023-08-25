package bbc.y2021f;

import java.util.Scanner;

/**
 * 题目 2618: 蓝桥杯2021年第十二届国赛真题-123
 * <p>
 * 时间限制: 1Sec 内存限制: 128MB 提交: 2315 解决: 319
 * <p>
 * 题目描述
 * <p>
 * 小蓝发现了一个有趣的数列，这个数列的前几项如下：
 * <p>
 * 1, 1, 2, 1, 2, 3, 1, 2, 3, 4, ...
 * <p>
 * 小蓝发现，这个数列前 1 项是整数 1，接下来 2 项是整数 1 至 2，接下来
 * <p>
 * 3 项是整数 1 至 3，接下来 4 项是整数 1 至 4，依次类推。
 * <p>
 * 小蓝想知道，这个数列中，连续一段的和是多少。
 * <p>
 * 输入
 * <p>
 * 输入的第一行包含一个整数 T，表示询问的个数。
 * <p>
 * 接下来 T 行，每行包含一组询问，其中第 i 行包含两个整数 li 和 ri，表示询问数列中第 li 个数到第 ri 个数的和。
 * <p>
 * 输出
 * <p>
 * 输出 T 行，每行包含一个整数表示对应询问的答案。
 * <p>
 * 样例输入
 * <p>
 * 3
 * <p>
 * 1 1
 * <p>
 * 1 3
 * <p>
 * 5 8
 * <p>
 * 样例输出
 * <p>
 * 1
 * <p>
 * 4
 * <p>
 * 8
 * <p>
 * 提示
 * <p>
 * 【评测用例规模与约定】
 * <p>
 * 对于 10% 的评测用例，1 ≤ T ≤ 30, 1 ≤ li ≤ ri ≤ 100。
 * <p>
 * 对于 20% 的评测用例，1 ≤ T ≤ 100, 1 ≤ li ≤ ri ≤ 1000。
 * <p>
 * 对于 40% 的评测用例，1 ≤ T ≤ 1000, 1 ≤ li ≤ ri ≤ 10^6。
 * <p>
 * 对于 70% 的评测用例，1 ≤ T ≤ 10000, 1 ≤ li ≤ ri ≤ 10^9。
 * <p>
 * 对于 80% 的评测用例，1 ≤ T ≤ 1000, 1 ≤ li ≤ ri ≤ 10^12。
 * <p>
 * 对于 90% 的评测用例，1 ≤ T ≤ 10000, 1 ≤ li ≤ ri ≤ 10^12。
 * <p>
 * 对于所有评测用例，1 ≤ T ≤ 100000, 1 ≤ li ≤ ri ≤ 10^12。
 */
public class _123 { // 80%

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            long x1 = scan.nextLong(), x2 = scan.nextLong();
            long n1 = getN(x1), n2 = getN(x2), sum = 0;
            if (n1 == n2) { // 在同一段中
                long len1 = n1 * (n1 - 1) / 2, sub1 = x1 - len1 - 1;
                sum += sub1 * (sub1 + 1) / 2;
                long sub2 = x2 - len1;
                sum += sub2 * (sub2 + 1) / 2;
                System.out.println(sum);
            } else {
                // 左边
                long len1 = n1 * (n1 - 1) / 2, sub1 = x1 - len1 - 1;
                sum += n1 * (n1 + 1) / 2 - sub1 * (sub1 + 1) / 2;
                // 右边
                long len2 = n2 * (n2 - 1) / 2, sub2 = x2 - len2;
                sum += sub2 * (sub2 + 1) / 2;
                // 1,3,6,10,15......数列的通项公式n*(n+1)/2,故前n项和为n(n+1)(n+2)/6;
                // 计算中间
                sum += n2 * (n2 - 1) * (n2 + 1) / 6 - n1 * (n1 + 1) * (n1 + 2) / 6;
                System.out.println(sum);
            }
        }
    }

    public static long getN(long x) {
        return (long) Math.ceil(Math.sqrt(0.25 + 2 * x) - 0.5);
    }
}
