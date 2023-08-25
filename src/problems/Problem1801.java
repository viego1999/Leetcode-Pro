package problems;

import java.util.PriorityQueue;

public class Problem1801 {

    public static void main(String[] args) {

    }

    public int getNumberOfBacklogOrders(int[][] orders) {
        long ans = 0;
        int mod = (int) 1e9 + 7;
        PriorityQueue<int[]> buys = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        PriorityQueue<int[]> sells = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        for (int[] order : orders) {
            if (order[2] == 0) {
                while (order[1] > 0 && !sells.isEmpty() && sells.peek()[0] <= order[0]) {
                    int[] cur = sells.poll();
                    if (cur[1] >= order[1]) {
                        if ((cur[1] -= order[1]) > 0) sells.offer(cur);
                        order[1] = 0;
                    } else order[1] -= cur[1];
                }
                if (order[1] > 0) buys.offer(order);
            } else {
                while (order[1] > 0 && !buys.isEmpty() && buys.peek()[0] >= order[0]) {
                    int[] cur = buys.poll();
                    if (cur[1] >= order[1]) {
                        if ((cur[1] -= order[1]) > 0) buys.offer(cur);
                        order[1] = 0;
                    } else order[1] -= cur[1];
                }
                if (order[1] > 0) sells.offer(order);
            }
        }
        while (!buys.isEmpty() || !sells.isEmpty()) {
            if (!buys.isEmpty()) ans = (ans + buys.poll()[1]) % mod;
            if (!sells.isEmpty()) ans = (ans + sells.poll()[1]) % mod;
        }
        return (int) ans;
    }

}
