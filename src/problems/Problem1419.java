package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1419
 * @since 2023/5/6 11:54
 */
public class Problem1419 {
    public static void main(String[] args) {

    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        String s = "croak";
        int[] cnts = new int[5];
        int ans = 1, cnt = 0, idx;
        for (char c : croakOfFrogs.toCharArray()) {
            cnts[idx = s.indexOf(c)]++;
            for (int j = 0; j < idx; j++) if (cnts[j] < cnts[idx]) return -1;
            if (idx == 0) cnt++;
            else if (idx == 4) ans = Math.max(ans, cnt--);
        }
        for (int i = 1; i < 5; i++) if (cnts[i] != cnts[i - 1]) return -1;
        return ans;
    }
}
