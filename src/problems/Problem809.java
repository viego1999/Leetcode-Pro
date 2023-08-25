package problems;

public class Problem809 {
    public static void main(String[] args) {

    }

    public int expressiveWords(String s, String[] words) {
        int ans = 0, m = s.length();
        char[] ss = s.toCharArray();
        for (String w : words) {
            int i = 0, j = 0, n = w.length();
            char[] ws = w.toCharArray();
            boolean f = true;
            while (i < m && j < n) {
                if (ss[i] != ws[j]) {
                    f = false;
                    break;
                }
                int t1 = i, t2 = j;
                while (i < m && ss[i] == ss[t1]) i++;
                while (j < n && ws[j] == ws[t2]) j++;
                int l1 = i - t1, l2 = j - t2;
                if (l1 != l2 && (l1 < l2 || l1 < 3)) {
                    f = false;
                    break;
                }
            }
            if (f && i == m && j == n) ans++;
        }
        return ans;
    }
}
