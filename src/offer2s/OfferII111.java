package offer2s;

import java.util.*;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII111
 * @since 2023/5/26 21:56
 */
public class OfferII111 {
    public static void main(String[] args) {

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = queries.size(), m = values.length;
        double[] ans = new double[n];
        Map<String, Map<String, Double>> map = new HashMap<>(), memory = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String a = equations.get(i).get(0), b = equations.get(i).get(1);
            Map<String, Double> map1 = map.getOrDefault(a, new HashMap<>());
            Map<String, Double> map2 = map.getOrDefault(b, new HashMap<>());
            map1.put(b, values[i]);
            map2.put(a, 1. / values[i]);
            map.put(a, map1);
            map.put(b, map2);
        }
        for (String u : map.keySet()) dfs(map, memory, u, u, 1.);
        for (int i = 0; i < n; i++) {
            String a = queries.get(i).get(0), b = queries.get(i).get(1);
            ans[i] = memory.getOrDefault(a, new HashMap<>()).getOrDefault(b, -1.);
        }
        return ans;
    }

    public void dfs(Map<String, Map<String, Double>> map, Map<String, Map<String, Double>> memory, String s, String u, double val) {
        for (Map.Entry<String, Double> entry : map.get(u).entrySet()) {
            String v = entry.getKey();
            double d = entry.getValue();
            if (memory.containsKey(s) && memory.get(s).containsKey(v)) continue;
            Map<String, Double> map1 = memory.getOrDefault(s, new HashMap<>());
            map1.put(v, val * d);
            memory.put(s, map1);
            dfs(map, memory, s, v, val * d);
        }
    }
}
