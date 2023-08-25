package bbc.y2021a;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * <p>
 * 给定序列 (a1, a2, · · · , an) = (1, 2, · · · , n)，即 ai = i。
 * <p>
 * 小蓝将对这个序列进行 m 次操作，每次可能是将 a1, a2, · · · , aqi 降序排列，或者将 aqi , aqi+1, · · · , an 升序排列。
 * <p>
 * 请求出操作完成后的序列。
 * <p>
 * 输入
 * <p>
 * 输入的第一行包含两个整数 n, m，分别表示序列的长度和操作次数。
 * <p>
 * 接下来 m 行描述对序列的操作，其中第 i 行包含两个整数 pi, qi 表示操作类型和参数。当 pi = 0 时，表示将 a1, a2, · · · , aqi 降序排列；
 * 当 pi = 1 时，表示将 aqi , aqi+1, · · · , an 升序排列。
 * <p>
 * 输出
 * <p>
 * 输出一行，包含 n 个整数，相邻的整数之间使用一个空格分隔，表示操作完成后的序列。
 * <p>
 * 样例输入
 * <p>
 * 3 3
 * <p>
 * 0 3
 * <p>
 * 1 2
 * <p>
 * 0 2
 * <p>
 * 样例输出
 * <p>
 * 3 1 2
 * <p>
 * 提示
 * <p>
 * 【样例说明】
 * <p>
 * 原数列为 (1, 2, 3)。 第 1 步后为 (3, 2, 1)。 第 2 步后为 (3, 1, 2)。 第 3 步后为 (3, 1, 2)。与第 2 步操作后相同，因为前两个数已经是降序了。
 * <p>
 * 【评测用例规模与约定】
 * <p>
 * 对于 30% 的评测用例，n, m ≤ 1000；
 * <p>
 * 对于 60% 的评测用例，n, m ≤ 5000；
 * <p>
 * 对于所有评测用例，1 ≤ n, m ≤ 100000，0 ≤ ai ≤ 1，1 ≤ bi ≤ n。
 */
public class BiSort { // TLE 60%
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = i;
        while (m-- > 0) {
            int p = scan.nextInt(), q = scan.nextInt();
            if (p == 0) sort(arr, 1, q, true);
            else sort(arr, q, n, false);
        }
        for (int i = 1; i <= n; i++) System.out.print(arr[i] + " ");
    }

    public static void sort(int[] arr, int l, int r, boolean reverse) {
        Arrays.sort(arr, l, r + 1);
        if (reverse) {
            while (l < r) {
                int t = arr[l];
                arr[l++] = arr[r];
                arr[r--] = t;
            }
        }
    }
}
