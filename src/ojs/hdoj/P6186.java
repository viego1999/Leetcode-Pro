package ojs.hdoj;

import java.util.Scanner;

/**
 * 问题描述
 * <p>
 * 小A已经上大学，主修计算机和科学。
 * <p>
 * 今天他在《算法课》中学习了位运算，作为家庭作业，他遇到了一个问题。
 * <p>
 * 问题是：
 * <p>
 * 你给了 n 个非负整数一个1,一个2, ⋯ ,一个n，以及一些查询。
 * <p>
 * 一个查询只包含一个正整数 p，这意味着您
 * <p>
 * 被要求回答所有整数的位运算（与、或、异或）的结果，除了一个p.
 * <p>
 * <p>
 * 输入
 * <p>
 * 测试用例不超过 15 个。
 * <p>
 * 每个测试用例
 * <p>
 * 以一行中的两个正整数 n 和 p 开头，表示正整数的个数和查询的个数。
 * <p>
 * 2≤n, q ≤10^5
 * <p>
 * 然后是 n 个非负整数a1,a2, ⋯ ,an排成一行，0≤ ai ≤ 10^9对于范围 [1,n] 中的每个 i。
 * <p>
 * 之后有q 个正整数p1,p2, ⋯ ,pq在 q 行中，1≤ pi ≤ n对于范围 [1,q] 中的每个 i。
 * <p>
 * <p>
 * 输出
 * <p>
 * 对于每个查询 p，输出三个非负整数表示除一个p在一条线上。
 * <p>
 * <p>
 * 样本输入
 * <p>
 * 3 3
 * <p>
 * 1 1 1
 * <p>
 * 1
 * <p>
 * 2
 * <p>
 * 3
 * <p>
 * 样本输出
 * <p>
 * 1 1 0
 * <p>
 * 1 1 0
 * <p>
 * 1 1 0
 */
public class P6186 {
    static int N = (int) 1e5 + 5;
    static int[] arr = new int[N];
    static int[] sa = new int[N], sb = new int[N], sc = new int[N];
    static int[] ea = new int[N], eb = new int[N], ec = new int[N];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt(), q = scan.nextInt();
            sa[1] = sb[1] = sc[1] = arr[1] = scan.nextInt();
            for (int i = 2; i <= n; i++) {
                sa[i] = sa[i - 1] & (arr[i] = scan.nextInt());
                sb[i] = sb[i - 1] | arr[i];
                sc[i] = sc[i - 1] ^ arr[i];
            }
            ea[n] = eb[n] = ec[n] = arr[n];
            for (int i = n - 1; i > 0; i--) {
                ea[i] = ea[i + 1] & arr[i];
                eb[i] = eb[i + 1] | arr[i];
                ec[i] = ec[i + 1] ^ arr[i];
            }
            while (q-- > 0) {
                int t = scan.nextInt();
                if (t == 1) {
                    System.out.println(ea[2] + " " + eb[2] + " " + ec[2]);
                } else if (t == n) {
                    System.out.println(sa[n - 1] + " " + sb[n - 1] + " " + sc[n - 1]);
                } else {
                    System.out.println((sa[t - 1] & ea[t + 1]) + " " + (sb[t - 1] | eb[t + 1]) + " " + (sc[t - 1] ^ ec[t + 1]));
                }
            }
        }
    }
}
