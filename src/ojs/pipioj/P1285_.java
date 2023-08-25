package ojs.pipioj;

import java.util.*;

public class P1285_ {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        List<Integer>[] adjacency = new ArrayList[n];
        for (int i = 0; i < n; i++) adjacency[i] = new ArrayList<>();
        while (m-- > 0) {
            int x = scan.nextInt(), y = scan.nextInt();
            adjacency[x - 1].add(y - 1);
        }
        System.out.println(topoSort(adjacency) ? "yes" : "no");
    }

    public static boolean topoSort(List<Integer>[] adjacency) {
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
}
