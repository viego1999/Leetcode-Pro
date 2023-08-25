package problems;

public class Problem1769 {
    public static void main(String[] args) {

    }

    public int[] minOperations_(String boxes) {
        char[] cs = boxes.toCharArray();
        int n = cs.length, t = cs[0] - '0', k = cs[n - 1] - '0', prev = 0, last = 0;
        int[] ans = new int[n];
        for (int i = 1, j = n - 2; i < n || j >= 0; i++, j--) {
            ans[i] += prev = prev + t; // t-i前面1的个数，每个1都得多走1步从i-1到i
            ans[j] += last = last + k; // k-j后面1的个数，每个1都得多走1步从j+1到j
            if (cs[i] == '1') t++;
            if (cs[j] == '1') k++;
        }
        return ans;
    }

    public int[] minOperations(String boxes) {
        char[] cs = boxes.toCharArray();
        int n = cs.length;
        int[] ans = new int[n];
        for (int i = 1, t = cs[0] - '0'; i < n; i++) {
            ans[i] = ans[i - 1] + t; // t-前面1的个数，每个1都得多走1步从i-1到i
            if (cs[i] == '1') t++;
        }
        for (int i = n - 2, t = cs[n - 1] - '0', last = 0; i >= 0; i--) {
            ans[i] += (last = last + t);
            if (cs[i] == '1') t++;
        }
        return ans;
    }
}
