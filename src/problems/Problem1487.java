package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1487
 * @since 2023/3/3 0:20
 */
public class Problem1487 {
    public static void main(String[] args) {

    }

    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        int n = names.length;
        for (int i = 0; i < n; i++) {
            String name = names[i], temp;
            if (!map.containsKey(name)) map.put(name, 1);
            else {
                int cnt = map.get(name);
                while (true) {
                    temp = name + "(" + cnt + ")";
                    if (!map.containsKey(temp)) {
                        names[i] = temp;
                        break;
                    } else cnt++;
                }
                map.put(name, cnt + 1);
                map.put(temp, 1);
            }
        }
        return names;
    }
}
