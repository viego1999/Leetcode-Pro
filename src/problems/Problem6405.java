package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6405
 * @since 2023/4/29 22:32
 */
public class Problem6405 {
    public static void main(String[] args) {

    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        Set<Integer> set, set1 = new HashSet<>(), set2 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set1.add(A[i]);
            set2.add(B[i]);
            set = new HashSet<>(set1);
            set.retainAll(set2);
            ans[i] = set.size();
        }
        return ans;
    }
}
