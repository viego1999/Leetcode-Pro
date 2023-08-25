package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1253
 * @since 2023/6/29 14:01
 */
public class Problem1253 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = colsum.length;
        int[][] array = new int[2][n];
        for (int i = 0; i < n; i++) {
            if (colsum[i] == 2) {
                if (upper > 0 && lower > 0) {
                    array[0][i] = array[1][i] = 1;
                    upper--;
                    lower--;
                } else return new ArrayList<>();
            }
        }
        for (int i = 0; i < n; i++) {
            if (colsum[i] == 1) {
                if (upper > 0) {
                    array[0][i] = 1;
                    upper--;
                } else if (lower > 0) {
                    array[1][i] = 1;
                    lower--;
                } else return new ArrayList<>();
            }
        }
        if (upper != 0 || lower != 0) return new ArrayList<>();
        return new ArrayList(Arrays.asList(array[0], array[1]));
    }
}
