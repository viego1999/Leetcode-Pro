package problems;

public class Problem481 {
    public static void main(String[] args) {

    }

    public int magicalString(int n) {
        int ans = 0, i = 2, j = 2;
        int[] s = new int[n + 5];
        s[0] = 1;
        s[1] = s[2] = 2;
        while (j < n) {
            if (s[i++] == 1) {
                if (s[j] == 2) s[++j] = 1;
                else s[++j] = 2;
            } else {
                if (s[j] == 1) s[++j] = s[++j] = 2;
                else s[++j] = s[++j] = 1;
            }
        }
        for (i = 0; i < n; i++) if (s[i] == 1) ans++;
        return ans;
    }
}
