package problems;

public class Problem1742 {
    public static void main(String[] args) {

    }

    public int countBalls(int lowLimit, int highLimit) {
        int[] hash = new int[50];
        int ans = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            ans = Math.max(ans, ++hash[getSum(i)]);
        }
        return ans;
    }

    public int getSum(int n) {
        int x = 0;
        while (n != 0) {
            x += n % 10;
            n /= 10;
        }
        return x;
    }

    int[] hash = new int[50], arr = new int[6];
    int ans = 0, low, pos = 0;

    public int countBalls_(int lowLimit, int highLimit) {
        low = lowLimit;
        while (highLimit != 0) {
            arr[pos++] = highLimit % 10;
            highLimit /= 10;
        }
        dfs(pos - 1, 0, 0, true);
        return ans;
    }

    public void dfs(int pos, int sum, int num, boolean limit) {
        if (pos == -1) ans = Math.max(ans, hash[sum] += (num < low ? 0 : 1));
        else {
            int up = limit ? arr[pos] : 9;
            for (int i = 0; i <= up; i++) {
                dfs(pos - 1, sum + i, num * 10 + i, limit && i == up);
            }
        }
    }
}
