package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem30_ {
    public static void main(String[] args) {
        System.out.println(findSubstringS("barfoothefoobarman", new String[]{"foo", "bar"}));
    }

    public List<Integer> findSubstringS2(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int len = words[0].length(), n = s.length();
        Map<String, Integer> map = new HashMap<>(), tmp = new HashMap<>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        for (int i = 0; i < len; i++) {
            int l = i, r = i;
            tmp.clear();
            while (r + len <= n) {
                String str1 = s.substring(r, (r += len));
                if (!map.containsKey(str1)) {
                    l = r;
                    tmp.clear();
                } else {
                    tmp.put(str1, tmp.getOrDefault(str1, 0) + 1);
                    while (tmp.get(str1) > map.get(str1)) {
                        String str2 = s.substring(l, (l += len));
                        tmp.put(str2, tmp.get(str2) - 1);
                    }
                    if (tmp.equals(map)) ans.add(l);
                }
            }
        }
        return ans;
    }

    public static List<Integer> findSubstringS(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int len = words[0].length(), n = s.length(), nums = words.length;
        Map<String, Integer> map = new HashMap<>(), tmp = new HashMap<>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        for (int i = 0; i < len; i++) {
            int l = i, r = i, cnt = 0;
            tmp.clear();
            while (r + len <= n) {
                String str1 = s.substring(r, (r += len));
                if (!map.containsKey(str1)) {
                    cnt = 0;
                    l = r;
                    tmp.clear();
                } else {
                    cnt++;
                    tmp.put(str1, tmp.getOrDefault(str1, 0) + 1);
                    while (tmp.get(str1) > map.get(str1)) {
                        String str2 = s.substring(l, (l += len));
                        tmp.put(str2, tmp.get(str2) - 1);
                        cnt--;
                    }
                    if (cnt == nums) ans.add(l);
                }
            }
        }
        return ans;
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int len = words[0].length(), totalLen = len * words.length, n = s.length();
        Map<String, Integer> map = new HashMap<>(), tmp = new HashMap<>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        for (int i = 0; i + totalLen <= n; i++) {
            String str = s.substring(i, i + totalLen);
            tmp.clear();
            for (int j = 0; j < str.length(); j += len) {
                String t = str.substring(j, j + len);
                tmp.put(t, tmp.getOrDefault(t, 0) + 1);
            }
            if (tmp.equals(map)) ans.add(i);
        }
        return ans;
    }
}
