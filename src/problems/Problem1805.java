package problems;

import java.util.HashSet;
import java.util.Set;

public class Problem1805 {
    public static void main(String[] args) {

    }

    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        char[] cs = word.toCharArray();
        for (int i = 0, j = 0, n = cs.length; j < n; j++) {
            while (i < n && cs[i] >= 'a' && cs[i] <= 'z') i++;
            j = i;
            while (j < n && cs[j] >= '0' && cs[j] <= '9') j++;
            while (j - i > 1 && cs[i] == '0') i++;
            if (j != i) set.add(new String(cs, i, j - i));
            i = j;
        }
        return set.size();
    }
}
