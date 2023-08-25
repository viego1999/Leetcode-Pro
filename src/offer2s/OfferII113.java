package offer2s;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII113
 * @since 2023/5/26 23:14
 */
public class OfferII113 {
    public static void main(String[] args) {

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjacency = new ArrayList[numCourses];
        int[] inDegrees = new int[numCourses], res = new int[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) adjacency[i] = new ArrayList<>();
        for (int[] prerequisite : prerequisites) {
            ++inDegrees[prerequisite[0]];
            adjacency[prerequisite[1]].add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses; i++) if (inDegrees[i] == 0) queue.offer(i);
        int idx = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            res[idx++] = u;
            numCourses--;
            for (int v : adjacency[u]) if (--inDegrees[v] == 0) queue.offer(v);
        }
        if (numCourses > 0) return new int[0];
        return res;
    }
}
