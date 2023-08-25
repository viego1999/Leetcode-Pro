package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1073
 * @since 2023/5/18 10:17
 */
public class Problem1073 {
    public static void main(String[] args) {

    }

    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int i = arr1.length - 1, j = arr2.length - 1, carry = 0;
        List<Integer> ans = new ArrayList<>();
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = carry;
            if (i >= 0) x += arr1[i];
            if (j >= 0) x += arr2[j];
            if (x >= 2) {
                ans.add(x - 2);
                carry = -1;
            } else if (x >= 0) {
                ans.add(x);
                carry = 0;
            } else {
                ans.add(1);
                carry = 1;
            }
            --i;
            --j;
        }
        while (ans.size() > 1 && ans.get(ans.size() - 1) == 0) ans.remove(ans.size() - 1);
        int[] ret = new int[ans.size()];
        for (i = 0; i < ans.size(); i++) ret[i] = ans.get(ans.size() - i - 1);
        return ret;
    }
}
