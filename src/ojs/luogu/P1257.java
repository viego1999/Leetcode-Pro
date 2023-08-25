package ojs.luogu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName P1257
 * @since 2023/2/15 16:42
 */
public class P1257 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), i = 0;
        int[][] points = new int[m][2];
        while (m-- > 0) {
            points[i++] = new int[]{scanner.nextInt(), scanner.nextInt()};
        }
        // 对所有点按照横坐标排序，横坐标相等则按纵坐标升序
        Arrays.sort(points, (x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
        System.out.printf("%.4f", solve(points, 0, points.length - 1));
    }

    /**
     * 返回指定范围内的所有点中的最小距离
     *
     * @param points 横坐标升序排序后的点集
     * @param l      左边界
     * @param r      右边界
     * @return [l, r]所有点集中的最小距离
     */
    public static double solve(int[][] points, int l, int r) {
        double d = 0x3f3f3f3f;
        // 当只有一个点时
        if (l == r) return d;
        // 当只有两个点时
        if (r - l == 1) return distance(points[l], points[r]);
        int mid = l + r >> 1;
        // 找到左右两部分的最短距离 d1 和 d2
        double d1 = solve(points, l, mid);
        double d2 = solve(points, mid + 1, r);
        // 取最短距离为 d
        d = Math.min(d1, d2);
        List<int[]> temps = new ArrayList<>();
        // 以中轴开始，收集距离小于 d 的点集
        for (int i = l; i <= r; i++) {
            if (Math.abs(points[i][0] - points[mid][0]) <= d) {
                temps.add(points[i]);
            }
        }
        // 按纵坐标升序
        temps.sort((x, y) -> x[1] - y[1]);
        for (int i = 0; i < temps.size(); i++) {
            for (int j = i + 1; j < temps.size() && temps.get(j)[1] - temps.get(i)[1] < d; j++) {
                d = Math.min(d, distance(temps.get(i), temps.get(j)));
            }
        }
        return d;
    }

    /**
     * 计算两个点之间的距离
     *
     * @param a 点a
     * @param b 点b
     * @return a b之间的距离
     */
    public static double distance(int[] a, int[] b) {
        int x = a[0] - b[0], y = a[1] - b[1];
        return Math.sqrt(x * x + y * y);
    }
}
