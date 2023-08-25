package problems;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Problem1781 {
    public static void main(String[] args) {
        System.out.println(beautySum("aabcb"));
    }

    public static int beautySum(String s) {
        char[] cs = s.toCharArray();
        int ans = 0, n = cs.length;
        for (int i = 0; i < n; i++) {
            int[] cnts = new int[26];
            for (int j = i, max = 0, min; j < n; j++) {
                max = Math.max(max, ++cnts[cs[j] - 'a']);
                min = n;
                for (int k = 0; k < 26; k++)
                    if (cnts[k] > 0)
                        min = Math.min(min, cnts[k]);
                ans += max - min;
            }
        }
        return ans;
    }
}
