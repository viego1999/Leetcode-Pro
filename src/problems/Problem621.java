package problems;

import java.util.*;

public class Problem621 {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) map.put(c, map.getOrDefault(c, 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (Integer val : map.values()) pq.offer(val);
        int ans = 0;
        while (!pq.isEmpty()) {
            int cycle = Math.min(pq.size(), n + 1); // 当前执行次数，（n+1）为一轮最多执行几次任务
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < cycle; i++) {
                int poll = pq.poll();
                if (poll - 1 > 0) temp.add(poll - 1);
            }
            for (int i : temp) pq.offer(i);
            ans += pq.isEmpty() ? cycle : n + 1; // 中间每次都是执行n+1个任务，最后一轮执行cycle个任务即可
        }
        return ans;
    }
}
