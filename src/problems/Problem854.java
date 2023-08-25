package problems;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Problem854 {
    public static void main(String[] args) {

    }

    public int kSimilarity(String s1, String s2) {
        if (s1.equals(s2)) return 0;
        char[] dis = s2.toCharArray();
        Set<String> vis = new HashSet<>();
        int ans = 0, n = s1.length();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(s1);
        vis.add(s1);
        while (!queue.isEmpty()) {
            ans++;
            int size = queue.size();
            for (int i = 0,t = 0; i < size; i++) { // 遍历上一次交换的所有结果
                char[] cur = queue.poll().toCharArray();
                // 找到当前字符串与s2第一个不相等的字符位置
                while (cur[t] == dis[t]) t++;
                // 每次只交换一次，将交换一次所有的结果存入队列中
                for (int j = t + 1; j < n; j++) {
                    if (cur[j] == dis[t]) {
                        swap(cur, t, j); // 交换 t j
                        String tmp = new String(cur);
                        if (tmp.equals(s2)) return ans;
                        if (!vis.contains(tmp)) {
                            vis.add(tmp);
                            queue.offer(tmp);
                        }
                        swap(cur, t, j); // 恢复 t j
                    }
                }
            }
        }
        return -1;
    }

    public void swap(char[] cs, int i, int j) {
        char t = cs[i];
        cs[i] = cs[j];
        cs[j] = t;
    }
}
