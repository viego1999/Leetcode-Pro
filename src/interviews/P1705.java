package interviews;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName P1705
 * @since 2023/3/11 10:03
 */
public class P1705 {
    public static void main(String[] args) {

    }

    public String[] findLongestSubarray(String[] array) {
        int n = array.length, l = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0, s = 0, j; i < n; i++) {
            s += Character.isLetter(array[i].charAt(0)) ? -1 : 1;
            if (map.containsKey(s)) {
                if (ans < i - (j = map.get(s))) ans = i - (l = j);
            } else map.put(s, i);
        }
        return Arrays.copyOfRange(array, l + 1, l + ans);
    }
}
