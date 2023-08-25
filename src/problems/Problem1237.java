package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1237
 * @since 2023/2/18 9:33
 */
public class Problem1237 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= z; i++) {
            for (int j = 1; j <= z; j++) {
                if (customfunction.f(i, j) == z) ans.add(Arrays.asList(i, j));
            }
        }
        return ans;
    }


    /**
     * This is the custom function interface.<p>
     * You should not implement it, or speculate about its implementation
     */
    interface CustomFunction {

        /**
         * Note that f(x, y) is increasing with respect to both x and y.<p>
         *     i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
         * @param x x
         * @param y y
         * @return Returns f(x, y) for any given positive integers x and y.
         */
        public int f(int x, int y);
    }
}
