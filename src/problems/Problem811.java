package problems;

import java.util.*;

public class Problem811 {
    public static void main(String[] args) {

    }

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] strs1 = cpdomain.split(" ");
            String[] strs2 = strs1[1].split("\\.");
            int cnt = Integer.parseInt(strs1[0]);
            for (int i = 0, n = strs2.length; i < n; i++) {
                String str = String.join(".", Arrays.copyOfRange(strs2, i, n));
                map.put(str, map.getOrDefault(str, 0) + cnt);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue() + " " + entry.getKey());
        }
        return ans;
    }
}
