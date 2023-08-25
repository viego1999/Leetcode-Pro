package problems;

public class Problem1732 {
    public static void main(String[] args) {

    }

    public int largestAltitude(int[] gain) {
        int ans = 0, last = 0;
        for (int g : gain) {
            ans = Math.max(ans, last += g);
        }
        return ans;
    }
}
