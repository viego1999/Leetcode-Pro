package algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * This class is about whether the solution diagram has a loop.
 * <p>
 * <a href="https://blog.csdn.net/qq_38943651/article/details/108396570">link</a>
 *
 * @see Graph
 * @see GraphCycle
 * @see UndirectedGraph
 * @see Digraph
 */
public class GraphCycle {
    public static void main(String[] args) {
        UndirectedGraph ug = new UndirectedGraph();
        // 创建无向有环图
        List<Integer>[] adj1 = ug.createGraph(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 1}});
        System.out.println(ug.dfs(adj1));
        System.out.println(ug.topoSort(adj1));
        System.out.println(ug.unionFind(adj1));

        adj1 = ug.createGraph(4, new int[][]{{0, 1}, {1, 2}, {2, 3}});
        System.out.println(ug.dfs(adj1));
        System.out.println(ug.topoSort(adj1));
        System.out.println(ug.unionFind(adj1));

        Digraph digraph = new Digraph();

//        List<Integer>[] adg1 = ug.createGraph(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 1}});
//        System.out.println(digraph.topoSort(adg1));
//        System.out.println(digraph.dfs(adg1));
//        System.out.println(digraph.unionFind(adg1));
//
//        // 创建无环有向图
//        List<Integer>[] adg2 = digraph.createGraph(3, new int[][]{{0, 2}, {0, 1}, {1, 2}});
//        System.out.println(digraph.topoSort(adg2));
//        System.out.println(digraph.dfs(adg2));
//        System.out.println(digraph.unionFind(adg2));
//
//        // 创建有环有向图
//        List<Integer>[] adg3 = digraph.createGraph(3, new int[][]{{2, 0}, {0, 1}, {1, 2}});
//        System.out.println(digraph.topoSort(adg3));
//        System.out.println(digraph.dfs(adg3));
//        System.out.println(digraph.unionFind(adg3));
//
//        // 创建有环有向图
//        List<Integer>[] adg4 = digraph.createGraph(3, new int[][]{{0, 1}, {1, 2}, {2, 1}});
//        System.out.println(digraph.topoSort(adg4));
//        System.out.println(digraph.dfs(adg4));
//        System.out.println(digraph.unionFind(adg4));
    }
}

/**
 * This class is about undirected graph cycle problem.
 */
class UndirectedGraph {

    /**
     * 使用拓扑排序可以判断一个无向图中是否存在环，具体步骤如下：
     * <ul>
     *     <li>求出图中所有结点的度。</li>
     *     <li>将所有度 <= 1 的结点入队。（独立结点的度为 0）</li>
     *     <li>当队列不空时，弹出队首元素，把与队首元素相邻节点的度减一。如果相邻节点的度变为一，则将相邻结点入队。</li>
     *     <li>循环结束时判断已经访问的结点数是否等于 n。等于 n 说明全部结点都被访问过，无环；反之，则有环。</li>
     * </ul>
     *
     * @param adjacency 无向图邻接矩阵
     * @return 存在回路返回 true，否则为 false。
     */
    public boolean topoSort(List<Integer>[] adjacency) {
        int n = adjacency.length;
        Queue<Integer> queue = new ArrayDeque<>();
        int[] degrees = new int[n]; // 每个顶点的入度数组
        for (int i = 0; i < n; i++) {
            degrees[i] = adjacency[i].size();
            if (degrees[i] <= 1) queue.offer(i);
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            cnt++;
            int curr = queue.poll();
            for (int next : adjacency[curr]) {
                if (--degrees[next] == 1) queue.offer(next);
            }
        }
        return cnt != n;
    }

    boolean hasCycle = false;

    /**
     * 使用 DFS 可以判断一个无向图和有向中是否存在环。
     *
     * <ul>
     *     <li>深度优先遍历图，如果在遍历的过程中，发现某个结点有一条边指向已访问过的结点，并且这个已访问过的结点不是上一步访问的结点，则表示存在环。</li>
     *     <li>我们不能仅仅使用一个 bool 数组来表示结点是否访问过。规定每个结点都拥有三种状态，白、灰、黑。开始时所有结点都是白色，当访问过某个结点后，该 结点变为灰色，当该结点的所有邻接点都访问完，该节点变为黑色。</li>
     *     <li>那么我们的算法可以表示为：如果在遍历的过程中，发现某个结点有一条边指向灰色节点，并且这个灰色结点不是上一步访问的结点，那么存在环。</li>
     * </ul>
     *
     * @param adjacency 无向图邻接矩阵
     * @return 存在回路返回 true，否则返回 false
     */
    public boolean dfs(List<Integer>[] adjacency) {
        int n = adjacency.length;
        hasCycle = false;
        int[] visits = new int[n]; // 0-未访问，1-访问，2-领域节点全部访问
        for (int i = 0; i < n; i++) {
            if (visits[i] == 0) {
                dfs(adjacency, visits, i, -1);
                if (hasCycle) return true;
            }
        }
        return false;
    }

    public void dfs(List<Integer>[] adj, int[] visits, int curr, int prev) {
        visits[curr] = 1;
        for (int next : adj[curr]) {
            if (visits[next] == 1 && next != prev) {
                hasCycle = true;
                break;
            } else if (visits[next] == 0) dfs(adj, visits, next, curr);
        }
        visits[curr] = 2;
    }

    int[] fa;

    /**
     * 方法有错误
     *
     * @param adj x
     * @return x
     */
    public boolean unionFind(List<Integer>[] adj) {
        int n = adj.length;
        fa = new int[n];
        for (int i = 0; i < n; i++) fa[i] = i;
        for (int u = 0; u < n; u++) {
            for (int v : adj[u]) {
                if (fa[u] == fa[v]) return true;
                merge(v, u);
            }
        }
        return false;
    }

    /**
     * 寻找 x 的领队节点，当不为自己时，重新将 x 的父节点指向 x 父节点的领队节点
     *
     * @param x x
     * @return 返回 x 的领队节点
     */
    private int find(int x) {
        if (fa[x] == x) return x;
        return fa[x] = find(fa[x]);
    }

    /**
     * 将 x 的领队节点的父指向（并入） y 的领队节点 中，即
     *
     * @param x x
     * @param y y
     */
    private void merge(int x, int y) {
        fa[find(x)] = find(y);
    }

    public List<Integer>[] createGraph(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        return adj;
    }
}

/**
 * This class is about directed graph cycle problem.
 */
class Digraph {

    /**
     * 使用拓扑排序可以判断一个有向图中是否存在环，具体步骤如下：
     * <ul>
     *     <li>求出图中所有结点的度。</li>
     *     <li>将所有度 == 0 的结点入队。（独立结点的度为 0）</li>
     *     <li>当队列不空时，弹出队首元素，把与队首元素相邻节点的度减一。如果相邻节点的度变为 0，则将相邻结点入队。</li>
     *     <li>循环结束时判断已经访问的结点数是否等于 n。等于 n 说明全部结点都被访问过，无环；反之，则有环。</li>
     * </ul>
     *
     * @param adjacency 无向图邻接矩阵
     * @return 存在回路返回 true，否则为 false。
     */
    public boolean topoSort(List<Integer>[] adjacency) {
        int n = adjacency.length;
        Queue<Integer> queue = new ArrayDeque<>();
        int[] degrees = new int[n]; // 每个顶点的入度数组
        for (List<Integer> integers : adjacency) {
            for (int next : integers)
                degrees[next]++;
        }
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 0) queue.offer(i);
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            cnt++;
            int curr = queue.poll();
            for (int next : adjacency[curr]) {
                if (--degrees[next] == 0) queue.offer(next);
            }
        }
        return cnt != n;
    }

    boolean hasCycle = false;

    public boolean dfs(List<Integer>[] adj) {
        int n = adj.length;
        hasCycle = false;
        int[] visit = new int[n];
        for (int i = 0; i < n; i++) {
            if (visit[i] == 0) {
                dfs(adj, visit, i);
                if (hasCycle) return true;
            }
        }
        return false;
    }

    private void dfs(List<Integer>[] adj, int[] visit, int cur) {
        // 标记为当前正在访问
        visit[cur] = 1;
        for (int next : adj[cur]) {
            if (visit[next] == 1) {
                hasCycle = true;
                break;
            } else if (visit[next] == 0) dfs(adj, visit, next);
        }
        // 标记为已经访问完了
        visit[cur] = 2; // 当不加2时，A->C, A->B->C 这种情况也会判断为环
    }

    public List<Integer>[] createGraph(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
        }
        return adj;
    }

    int[] fa;

    public boolean unionFind(List<Integer>[] adj) {
        int n = adj.length;
        fa = new int[n];
        for (int i = 0; i < n; i++) fa[i] = i;
        for (int u = 0; u < n; u++) {
            for (int v : adj[u]) {
                if (fa[u] == v) return true;
                merge(v, u);
            }
        }
        return false;
    }

    /**
     * 寻找 x 的领队节点，当不为自己时，重新将 x 的父节点指向 x 父节点的领队节点
     *
     * @param x x
     * @return 返回 x 的领队节点
     */
    private int find(int x) {
        if (fa[x] == x) return x;
        return fa[x] = find(fa[x]);
    }

    /**
     * 将 x 的领队节点的父指向（并入） y 的领队节点 中，即
     *
     * @param x x
     * @param y y
     */
    private void merge(int x, int y) {
        fa[find(x)] = find(y);
    }
}
