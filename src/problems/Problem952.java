package problems;

import java.util.*;

/**
 * 952. 按公因数计算最大组件大小
 * 给定一个由不同正整数的组成的非空数组 nums ，考虑下面的图：
 * <p>
 * 有 nums.length 个节点，按从 nums[0] 到 nums[nums.length - 1] 标记；
 * 只有当 nums[i] 和 nums[j] 共用一个大于 1 的公因数时，nums[i] 和 nums[j]之间才有一条边。
 * 返回 图中最大连通组件的大小 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：nums = [4,6,15,35]
 * 输出：4
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：nums = [20,50,9,63]
 * 输出：2
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：nums = [2,3,6,7,4,12,21,39]
 * 输出：8
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] <= 105
 * nums 中所有值都 不同
 * <p>
 * link: https://leetcode.cn/problems/largest-component-size-by-common-factor/
 */
public class Problem952 {
    public static void main(String[] args) {
        System.out.println(largestComponentSizeBfs(new int[]{4, 6, 15, 35}));
    }

    public static int largestComponentSizeBfs(int[] nums) {
        int n = nums.length, ans = 0;
        boolean[] vis = new boolean[n];
        List<Integer>[] adjacency = new ArrayList[n];
        for (int i = 0; i < n; i++) adjacency[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (gcd(nums[i], nums[j]) > 1) {
                    adjacency[i].add(j);
                    adjacency[j].add(i);
                }
            }
        }
        for (int i = 0; i < n; i++) if (!vis[i]) ans = Math.max(ans, bfs(i, adjacency, vis));
        return ans;
    }

    private static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    private static int bfs(int i, List<Integer>[] adjacency, boolean[] vis) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(i);
        vis[i] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : adjacency[curr]) {
                if (!vis[next]) {
                    queue.offer(next);
                    vis[next] = true;
                    ans++;
                }
            }
        }
        return ans;
    }

    int N = (int) 1e5 + 5, ans = 0;
    int[] fa = new int[N], rank = new int[N], cnts = new int[N];

    public int largestComponentSize(int[] nums) {
        for (int i = 0; i < N; i++) fa[i] = i; // 初始化fa数组
        for (int num : nums) {
            for (int j = 2; j * j <= num; j++) { // 枚举能整除num的每一个大于1的数
                if (num % j == 0) { // 进行合并操作
                    merge(num, j);
                    merge(num, num / j);
                }
            }
        }
        for (int num : nums) ans = Math.max(ans, ++cnts[find(num)]); // 计数
        return ans;
    }

    public int find(int x) { // 查找x父节点，并进行路径压缩
        if (x == fa[x]) return x;
        fa[x] = find(fa[x]);
        return fa[x];
    }

    public void merge(int x, int y) { // 将x和y的父节点进行合并
        int i = find(x), j = find(y);
        if (rank[i] < rank[j]) fa[i] = j;
        else fa[j] = i;
        if (rank[i] == rank[j] && i != j) rank[i]++;
    }
}
