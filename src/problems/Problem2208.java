package problems;

import java.util.PriorityQueue;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2208
 * @since 2023/7/26 0:46
 */
public class Problem2208 {
    public static void main(String[] args) {

    }

    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>((x, y) -> Double.compare(y, x));
        int ans = 0;
        double sum = 0, cur = 0;
        for (int num : nums) {
            pq.offer(num * 1.);
            sum += num;
        }
        cur = sum;
        sum /= 2.;
        while (true) {
            if (cur <= sum) return ans;
            double poll = pq.poll();
            poll /= 2.;
            cur -= poll;
            pq.offer(poll);
            ans++;
        }
    }
}
