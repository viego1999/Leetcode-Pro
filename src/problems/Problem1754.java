package problems;

public class Problem1754 {
    public static void main(String[] args) {

    }

    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        char[] cs1 = word1.toCharArray(), cs2 = word2.toCharArray();
        int i = 0, j = 0, m = cs1.length, n = cs2.length;
        while (i < m && j < n) {
            if (cs1[i] < cs2[j]) sb.append(cs2[j++]);
            else if (cs1[i] > cs2[j]) sb.append(cs1[i++]);
            else {
                int k = i, l = j;
                while (k < m && l < n && cs1[k] == cs2[l]) {
                    k++;
                    l++;
                }
                int t1 = Math.min(k, m - 1), t2 = Math.min(l, n - 1);
                // k = m 表示 cs1[t1] = cs2[t2]，并且 cs1 已经到头了，故此时cs1[i,t1]字典序也小于cs2[j,t2]
                if (cs1[t1] < cs2[t2] || k == m) sb.append(cs2[j++]);
                else sb.append(cs1[i++]);
            }
        }
        if (i < m) sb.append(word1.substring(i));
        if (j < n) sb.append(word2.substring(j));
        return sb.toString();
    }
}
