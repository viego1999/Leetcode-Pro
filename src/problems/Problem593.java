package problems;

/**
 * 593. 有效的正方形
 * 给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。
 *
 * 点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。
 *
 * 一个 有效的正方形 有四条等边和四个等角(90度角)。
 *
 *
 *
 * 示例 1:
 *
 * 输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * 输出: True
 * 示例 2:
 *
 * 输入：p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
 * 输出：false
 * 示例 3:
 *
 * 输入：p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
 * 输出：true
 *
 *
 * 提示:
 *
 * p1.length == p2.length == p3.length == p4.length == 2
 * -104 <= xi, yi <= 104
 *
 * link: https://leetcode.cn/problems/valid-square/
 */
public class Problem593 {
    public static void main(String[] args) {

    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return check(p1, p2, p3, p4) || check(p1, p2, p4, p3) || check(p1, p3, p2, p4);
    }

    // 判断四边相等，对角线相等
    public boolean check(int[] p1, int[] p2, int[] p3, int[] p4) {
        int a = getLength(p1, p2), b = getLength(p1, p4), c = getLength(p2, p3), d = getLength(p3, p4);
        int x = getLength(p1, p3), y = getLength(p2, p4);
        return a == b && b == c && c == d && x == y && a != x && a != 0 && x != 0;
    }

    // 判断4边相等且一个角为直角
    public boolean check2(int[] p1, int[] p2, int[] p3, int[] p4) {
        int a = getLength(p1, p2), b = getLength(p1, p4), c = getLength(p2, p3), d = getLength(p3, p4);
        int x1 = p1[0] - p2[0], y1 = p1[1] - p2[1], x2 = p1[0] - p4[0], y2 = p1[1] - p4[1];
        return a == b && b == c && c == d && a != 0 && x1 * x2 + y1 * y2 == 0;
    }

    public int getLength(int[] p1, int[] p2) {
        int i = p1[0] - p2[0], j = p1[1] - p2[1];
        return i * i + j * j;
    }
}
