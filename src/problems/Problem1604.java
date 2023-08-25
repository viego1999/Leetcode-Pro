package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1604
 * @since 2023/2/7 0:26
 */
public class Problem1604 {
    public static void main(String[] args) {

    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> ans = new ArrayList<>();
        int n = keyName.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (x, y) -> keyName[x].equals(keyName[y]) ? keyTime[x].compareTo(keyTime[y]) : keyName[x].compareTo(keyName[y]));
        String last = "";
        for (int i = 0; i < n; i++) {
            while (i < n && last.equals(keyName[idx[i]])) i++;
            if (i + 2 < n && keyName[idx[i]].equals(keyName[idx[i + 2]]) &&
                    cal(keyTime[idx[i + 2]]) - cal(keyTime[idx[i]]) <= 60) {
                ans.add(keyName[idx[i]]);
                last = keyName[idx[i]];
                i += 2;
            }
        }
        return ans;
    }

    public int cal(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
}
