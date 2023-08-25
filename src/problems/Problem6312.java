package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6312
 * @since 2023/3/4 23:34
 */
public class Problem6312 {
    public static void main(String[] args) {

    }

    public int splitNum(int num) {
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            int t = num % 10;
            list.add(t);
            num /= 10;
        }
        list.sort((x, y) -> x - y);
        int a = 0, b = 0;
        for (int i = 0; i < list.size(); i++) {
            if ((i & 1) == 1) {
                a *= 10;
                a += list.get(i);
            } else {
                b *= 10;
                b += list.get(i);
            }
        }
        return a + b;
    }
}
