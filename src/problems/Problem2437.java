package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2437
 * @since 2023/5/9 16:08
 */
public class Problem2437 {
    public static void main(String[] args) {

    }

    public int countTime(String time) {
        String[] strs = time.split(":");
        int cnt1 = getCnts(strs[0], 23), cnt2 = getCnts(strs[1], 59);
        return Math.min(cnt1, cnt2) == 0 ? Math.max(1, Math.max(cnt1, cnt2)) : cnt1 * cnt2;
    }

    public int getCnts(String str, int end) {
        char c1 = str.charAt(0), c2 = str.charAt(1);
        if (c1 == '?' && c2 == '?') return end + 1;
        else if (c1 == '?') {
            int cnt = 0;
            for (int i = 0; i <= 9; i++) {
                if (i * 10 + (c2 - '0') <= end) cnt++;
            }
            return cnt;
        } else if (c2 == '?') {
            int cnt = 0;
            for (int i = 0; i <= 9; i++) {
                if ((c1 - '0') * 10 + i <= end) cnt++;
            }
            return cnt;
        } else return 0;
    }
}
