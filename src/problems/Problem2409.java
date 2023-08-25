package problems;

import java.util.Arrays;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2409
 * @since 2023/4/17 0:11
 */
public class Problem2409 {
    public static void main(String[] args) {

    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        if (leaveAlice.compareTo(arriveBob) > 0 || leaveBob.compareTo(arriveAlice) > 0) return 0;
        String[] strings = new String[]{arriveAlice, leaveAlice, arriveAlice, leaveAlice};
        Arrays.sort(strings);
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] strs1 = strings[1].split("-"), strs2 = strings[2].split("-");
        int m1 = Integer.parseInt(strs1[0]), d1 = Integer.parseInt(strs1[1]);
        int m2 = Integer.parseInt(strs2[0]), d2 = Integer.parseInt(strs2[1]);
        if (m1 == m2) return d2 - d1 + 1;
        int ans = 0;
        for (int i = m1 + 1; i < m2; i++) ans += days[i];
        return ans + days[m1] - d1 + d2;
    }
}
