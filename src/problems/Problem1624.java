package problems;

import java.util.Arrays;

public class Problem1624 {
    public static void main(String[] args) {

    }

    public int maxLengthBetweenEqualCharacters(String s) {
        int[] hash = new int[26];
        Arrays.fill(hash, -1);
        char[] cs = s.toCharArray();
        int ans = -1;
        for (int i = 0; i < cs.length; i++) {
            int idx = cs[i] - 'a';
            if (hash[idx] != -1) ans = Math.max(ans, i - hash[idx] - 1);
            else hash[idx] = i;
        }
        return ans;
    }
}
