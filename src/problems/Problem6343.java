package problems;

import java.util.*;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6343
 * @since 2023/4/30 11:13
 */
public class Problem6343 {
    public static void main(String[] args) {

    }

    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        long base = (long) (1e5 + 5);
        Set<Long> set = new HashSet<>();
        set.add(start[0] * base + start[1]);
        set.add(target[0] * base + target[1]);
        for (int[] road : specialRoads) {
            set.add(road[0] * base + road[1]);
            set.add(road[2] * base + road[3]);
        }
        int n = set.size();
        int[][] dis = new int[n][n];
        List<Long> list = new ArrayList<>(set);
        Map<Long, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(list.get(i), i);
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int x1 = (int) (list.get(i) / base), y1 = (int) (list.get(i) % base);
                int x2 = (int) (list.get(j) / base), y2 = (int) (list.get(j) % base);
                dis[i][j] = dis[j][i] = Math.abs(x1 - x2) + Math.abs(y1 - y2);
            }
        }
        for (int[] road : specialRoads) {
            int i = map.get(road[0] * base + road[1]), j = map.get(road[2] * base + road[3]);
            dis[i][j] = Math.min(dis[i][j], road[4]);
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }
        return dis[map.get(start[0] * base + start[1])][map.get(target[0] * base + target[1])];
    }
}
