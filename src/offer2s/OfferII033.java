package offer2s;

import java.util.*;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII033
 * @since 2023/4/25 22:51
 */
public class OfferII033 {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String s = new String(cs);
            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(str);
            map.put(s, list);
        }
        return new ArrayList<>(map.values());
    }
}
