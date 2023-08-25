package bbc.y2021f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 题目描述
 * <p>
 * 小蓝很喜欢吃巧克力，他每天都要吃一块巧克力。
 * <p>
 * 一天小蓝到超市想买一些巧克力。超市的货架上有很多种巧克力，每种巧克力有自己的价格、数量和剩余的保质期天数，小蓝只吃没过保质期的巧克力，请问小蓝
 * 最少花多少钱能买到让自己吃 x 天的巧克力。
 * <p>
 * 输入
 * <p>
 * 输入的第一行包含两个整数 x, n，分别表示需要吃巧克力的天数和巧克力的种类数。
 * <p>
 * 接下来 n 行描述货架上的巧克力，其中第 i 行包含三个整数 ai, bi, ci，表示第 i 种巧克力的单价为 ai，保质期还剩 bi 天（从现在开始的 bi 天可以
 * 吃），数量为 ci。
 * <p>
 * 输出
 * <p>
 * 输出一个整数表示小蓝的最小花费。如果不存在让小蓝吃 x 天的购买方案，输出ࠪ 1。
 * <p>
 * 样例输入
 * <p>
 * 10 3
 * <p>
 * 1 6 5
 * <p>
 * 2 7 3
 * <p>
 * 3 10 10
 * <p>
 * 样例输出
 * <p>
 * 18
 * <p>
 * 提示
 * <p>
 * 【样例说明】
 * <p>
 * 一种最佳的方案是第 1 种买 5 块，第 2 种买 2 块，第 3 种买 3 块。前 5 天
 * <p>
 * 吃第 1 种，第 6、7 天吃第 2 种，第 8 至 10 天吃第 3 种。
 * <p>
 * 【评测用例规模与约定】
 * <p>
 * 对于 30% 的评测用例，n, x ≤ 1000。
 * <p>
 * 对于所有评测用例，1 ≤ n, x ≤ 100000，1 ≤ ai, bi, ci ≤ 10^9。
 */
public class Chocolate {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 65536);
    static StringTokenizer tokenizer = new StringTokenizer("");

    static class Node {
        long price, time, nums;
        int id;
        public Node(int id, long price, long time, long nums) { this.id = id; this.price = price; this.time = time; this.nums = nums;}
    }

    /*
     * 将所有种类的巧克力按保质期从长到短排序，然后我们从后面几天开始选择吃哪块巧克力，对于第i天，我们将所有保质期满足能在第i天吃的巧克力都找出来，
     * 然后对它们按价格从小到大排序，选择价格最低的在第i天吃，并记录一下这种巧克力已经用掉了几块，如果全部都用掉了，那就不能再用了，这里我们用到了
     * 优先队列来动态维护当天能吃的各种巧克力，用map来维护不同种类的巧克力已经用掉了几块。
     */
    public static void main(String[] args) {
        int x = nextInt(), n = nextInt();
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.price, b.price)); // 按价格从小到大
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, nextLong(), nextLong(), nextLong());
        }
        Arrays.sort(nodes, (a, b) -> Long.compare(b.time, a.time)); // 根据保质期升序排列
        int j = 0;
        long ans = 0;
        // 从后往前 每一天选出符合保质期的最小价值的巧克力
        for (int i = x; i > 0; i--) {
            while (j < n && nodes[j].time >= i) {
                pq.offer(nodes[j++]);
            }
            if (pq.size() == 0) {
                System.out.println("-1");
                return;
            }
            Node node = pq.poll();
            ans += node.price;
            if ((node.nums -= 1) > 0) pq.offer(node);
        }
        System.out.println(ans);
    }

    public static String next() {
        while (!tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() { return Integer.parseInt(next()); }

    public static long nextLong() { return Long.parseLong(next()); }
}
