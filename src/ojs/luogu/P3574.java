package ojs.luogu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 农场物语
 * <p>
 * 在一个叫做比特村的小村庄中，有 n−1条路连接着这个村庄中的全部 n个房子。每两个房子之间都有一条唯一的通路。这些房子的编号为1至 n。
 * 1号房子属于村庄的管理员比特安萨尔。为了提升村庄的科技使用水平，n台电脑被快递到了比特安萨尔的房子。每个房子都应该有一台电脑，
 * 且分发电脑的任务就落在了比特安萨尔的肩上。比特村的居民一致同意去玩农场物语这个游戏的最新快照版，而且好消息是他们很快就要得到他们
 * 最新的高配置电脑了。比特安萨尔将所有电脑都装在了他的卡车上，而且他准备好完成这个艰巨的任务了。他的汽油恰好够走每条路两遍。在每个
 * 房子边，比特安萨尔把电脑贴心的配送给居民，且立即前往下一个房子。（配送过程不花费任何时间）只要每间房子的居民拿到了他们的新电脑，
 * 它们就会立即开始安装农场物语。安装农场物语所用的时间根据居民的科技素养而定。幸运的是，每间房子中居民的科技素养都是已知的。在比特安
 * 萨尔配送完所有电脑后，他会回到他自己的1号房子去安装他自己的农场物语。用卡车开过每条路的时间恰好是1分钟，而居民开电脑箱的时间可以忽
 * 略不计。（因为他们太想玩农场物语了）请你帮助比特安萨尔算出从开始配送到所有居民都玩上了农场物语的最少时间。
 */
public class P3574 {

    static int[] f, s; // f[x]表示x子树内的最大值，s[x]表示走完x的字数后回到x的总时间
    static List<Integer> sons;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        f = new int[n + 5];
        s = new int[n + 5];
        sons = new ArrayList<>(n + 5);
        List<Integer>[] adjs = new ArrayList[n + 5];
        for (int i = 0; i < adjs.length; i++) adjs[i] = new ArrayList<>();
        int[] times = new int[n + 5];
        for (int i = 1; i <= n; i++) times[i] = scan.nextInt();
        for (int i = 1; i < n; i++) {
            int u = scan.nextInt(), v = scan.nextInt();
            adjs[u].add(v);
            adjs[v].add(u);
        }
        dfs(adjs, times, 1, 0);
        System.out.println(Math.max(f[1], s[1] + times[1]));
    }

    public static void dfs(List<Integer>[] adjs, int[] times, int curr, int father) {
        if (curr != 1) f[curr] = times[curr]; // 如果不是根节点，算上自己

        for (int next : adjs[curr]) { // 遍历所有可能到达的点
            if (next != father) { // 如果不是来的时候的点，就递归计算
                dfs(adjs, times, next, curr); // 向下递归计算
            }
        }

        sons.clear(); // 清除邻居（子）节点列表

        for (int next : adjs[curr]) { // 找出所有可能的点，除了自己的父节点
            if (next != father) sons.add(next);
        }

        sons.sort((x, y) -> s[x] - f[x] - s[y] + f[y]); // 自定义排序

        for (int son : sons) { // 树形dp
            f[curr] = Math.max(f[curr], f[son] + s[curr] + 1);
            s[curr] += s[son] + 2;
        }
    }
}
