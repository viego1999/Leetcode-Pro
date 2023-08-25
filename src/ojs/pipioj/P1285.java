package ojs.pipioj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 5 4
 * 1 2
 * 2 3
 * 3 4
 * 4 5
 */
public class P1285 {
    static boolean cycle = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        List<Integer>[] adjacency = new ArrayList[n];
        for (int i = 0; i < n; i++) adjacency[i] = new ArrayList<>();
        while (m-- > 0) {
            int x = scan.nextInt(), y = scan.nextInt();
            adjacency[x - 1].add(y - 1);
        }
        dfs(adjacency);
    }

    public static void dfs(List<Integer>[] adjacency) {
        int n = adjacency.length;
        int[] visits = new int[n]; // 0-未访问，1-访问，2-领域节点全部访问
        for (int i = 0; i < n; i++) {
            if (visits[i] == 0) {
                dfs(adjacency, visits, i);
                if (cycle) {
                    System.out.println("yes");
                    break;
                }
            }
        }
        if (!cycle) System.out.println("no");
    }

    public static void dfs(List<Integer>[] adj, int[] visits, int curr) {
        visits[curr] = 1;
        for (int next : adj[curr]) {
            if (visits[next] == 1) {
                cycle = true;
                break;
            } else if (visits[next] == 0) {
                dfs(adj, visits, next);
            }
        }
        visits[curr] = 2;
    }
}
