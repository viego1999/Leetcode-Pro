package problems;

import java.util.PriorityQueue;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1792
 * @since 2023/2/19 1:34
 */
public class Problem1792 {
    public static void main(String[] args) {

    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Long.compare((long) (x[1] + 1) * x[1] * (y[1] - y[0]), (long) (y[1] + 1) * y[1] * (x[1] - x[0])));
        double sum = 0.;
        for (int[] clazz : classes) pq.offer(clazz);
        for (int i = 0; i < extraStudents; i++) {
            int[] clazz = pq.poll();
            pq.offer(new int[]{clazz[0] + 1, clazz[1] + 1});
        }
        while (!pq.isEmpty()) {
            int[] clazz = pq.poll();
            sum += clazz[0] * 1. / clazz[1];
        }
        return sum / classes.length;
    }
}
