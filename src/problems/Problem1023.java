package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1023
 * @since 2023/4/14 10:28
 */
public class Problem1023 {
    public static void main(String[] args) {

    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        for (String query : queries) {
            int p = 0;
            boolean flag = true;
            for (int i = 0; i < query.length() && flag; i++) {
                char c = query.charAt(i);
                if (p < pattern.length() && pattern.charAt(p) == c) p++;
                else if (Character.isUpperCase(c)) flag = false;
            }
            ans.add(flag && p == pattern.length());
        }
        return ans;
    }

    public List<Boolean> camelMatch__(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        List<String> ps = new ArrayList<>();
        List<List<String>> qs = new ArrayList<>();
        for (int i = 0; i < pattern.length();) {
            int j = i + 1;
            while (j < pattern.length() && Character.isLowerCase(pattern.charAt(j))) j++;
            ps.add(pattern.substring(i, i = j));
        }
        for (String query : queries) {
            List<String> q = new ArrayList<>();
            int i = 0;
            if (Character.isUpperCase(pattern.charAt(0))) {
                while (i < query.length() && Character.isLowerCase(query.charAt(i))) i++;
            }
            while (i < query.length()) {
                int j = i + 1;
                while (j < query.length() && Character.isLowerCase(query.charAt(j))) j++;
                q.add(query.substring(i, i = j));
            }
            qs.add(q);
        }
        for (List<String> q : qs) {
            if (q.size() != ps.size()) ans.add(false);
            else {
                boolean flag = true;
                for (int i = 0; i < ps.size() && flag; i++) {
                    int a = 0, b = 0;
                    String str1 = q.get(i), str2 = ps.get(i);
                    while (a < str1.length() && b < str2.length()) {
                        if (str1.charAt(a) == str2.charAt(b)) b++;
                        a++;
                    }
                    flag = b == str2.length();
                }
                ans.add(flag);
            }
        }
        return ans;
    }
}
