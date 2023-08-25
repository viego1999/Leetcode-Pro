package problems;

public interface Problem2042 {
    default boolean areNumbersAscending(String s) {
        char[] cs = s.toCharArray();
        int prev = -1, i = 0, n = cs.length;
        while (i < n) {
            while (i < n && (cs[i] < '0' || cs[i] > '9')) i++;
            int j = i;
            while (j < n && cs[j] >= '0' && cs[j] <= '9') j++;
            if (j > i) {
                int t = Integer.parseInt(s.substring(i, j));
                if (t <= prev) return false;
                prev = t;
            }
            i = j + 1;
        }
        return true;
    }
}
