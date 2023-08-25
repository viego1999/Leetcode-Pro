package problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Problem1807 {

    public static void main(String[] args) {

    }

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> k : knowledge) map.put(k.get(0), k.get(1));
        char[] cs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, t, n = cs.length; (t = i) < n; i++) {
            if (cs[i] != '(') sb.append(cs[i]);
            else {
                while (i < n && cs[i] != ')') i++;
                sb.append(map.getOrDefault(s.substring(t + 1, i), "?"));
            }
        }
        return sb.toString();
    }

}
