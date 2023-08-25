package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2106
 * @since 2023/5/4 10:56
 */
public class Problem2106 {
    public static void main(String[] args) {

    }

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length, ans = 0, l = 0, r = 0, sum = 0;
        while (r < n) {
            sum += fruits[r][1];
            while (l <= r && getSteps(fruits, startPos, l, r) > k) sum -= fruits[l++][1];
            ans = Math.max(ans, sum);
            r++;
        }
        return ans;
    }

    public int getSteps(int[][] fruits, int startPos, int l, int r) {
        int left = fruits[l][0], right = fruits[r][0];
        if (right <= startPos) return startPos - left;
        else if (left >= startPos) return right - startPos;
        else return right - left + Math.min(startPos - left, right - startPos);
    }
}
