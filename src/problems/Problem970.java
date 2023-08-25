package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem970
 * @since 2023/5/2 10:59
 */
public class Problem970 {
    public static void main(String[] args) {

    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= 21; i++) {
            for (int j = 0; j <= 21; j++) {
                double m = Math.pow(x, i) + Math.pow(y, j);
                if (m > bound) break;
                set.add((int) m);
            }
        }
        return new ArrayList<>(set);
    }
}
