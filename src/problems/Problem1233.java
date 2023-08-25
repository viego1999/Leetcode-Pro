package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1233
 * @since 2023/2/8 0:14
 */
public class Problem1233 {
    public static void main(String[] args) {

    }

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans = new ArrayList<>();
        for (int i = 0, j; i < folder.length; ) {
            j = i++;
            String s = folder[j] + "/";
            while (i < folder.length && folder[i].startsWith(s)) i++;
            ans.add(folder[j]);
        }
        return ans;
    }
}
