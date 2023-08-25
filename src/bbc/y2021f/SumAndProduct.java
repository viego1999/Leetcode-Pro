package bbc.y2021f;

import java.util.Scanner;

/**
 * 题目描述
 * <p>
 * 给定一个数列 A = (a1, a2, · · · , an)，问有多少个区间 [L, R] 满足区间内元素的乘积等于他们的和，
 * 即 aL · aL+1 · · · aR = aL + aL+1 + · · · + aR 。
 * <p>
 * 输入
 * <p>
 * 输入第一行包含一个整数 n，表示数列的长度。
 * <p>
 * 第二行包含 n 个整数，依次表示数列中的数 a1, a2, · · · , an。
 * <p>
 * 输出
 * <p>
 * 输出仅一行，包含一个整数表示满足如上条件的区间的个数。
 * <p>
 * 样例输入
 * <p>
 * 4
 * <p>
 * 1 3 2 2
 * <p>
 * 样例输出
 * <p>
 * 6
 * <p>
 * 提示
 * <p>
 * 【样例解释】
 * <p>
 * 符合条件的区间为 [1, 1], [1, 3], [2, 2], [3, 3], [3, 4], [4, 4]。
 * <p>
 * 【评测用例规模与约定】
 * <p>
 * 对于 20% 的评测用例，n ≤ 3000；
 * <p>
 * 对于 50% 的评测用例，n ≤ 20000；
 * <p>
 * 对于所有评测用例，1 ≤ n ≤ 200000, 1 ≤ ai ≤ 200000。
 */
public class SumAndProduct {
    static int N = (int) 2e5 + 10;
    static int[] arr = new int[N];
    static long[] sums = new long[N]; // 前缀和数组
    static int[] pos = new int[N]; // 记录不为1的数的位置数组

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), t = 0;
        pos[t++] = 0;
        for (int i = 1; i <= n; i++) {
            int a = scan.nextInt();
            arr[i] = a;
            sums[i] = sums[i - 1] + a;
            if (a != 1) pos[t++] = i;
        }
        pos[t++] = n + 1;
        long ans = 0;
        for (int l = 1; l <= n; l++) {
            long res = 1;
            int cur = binarySearch(pos, 1, t, l); // 找到第一个大于等于l的不为1的位置
            for (int j = cur; j < t; j++) {
                int cnt = pos[j] - pos[j - 1] - 1;
                int r = pos[j];
                if (res <= sums[r - 1] - sums[l - 1]) { // 如果连续的1区间内有解
                    if (sums[r - 1] - sums[l - 1] - res < cnt) { // 连续1内有解
                        ans++;
                    }
                }
                res *= arr[r];
                if (r != n + 1 && res == sums[r] - sums[l - 1]) { // 当前不为1的位置 是一个解
                    ans++;
                }
                if (res >= 4e10) break;
            }
        }
        System.out.println(ans);
    }

    public static int binarySearch(int[] a, int l, int r, int key) {
        while (l < r) {
            int mid = l + r >>> 1;
            if (a[mid] < key) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
