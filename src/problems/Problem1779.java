package problems;

public class Problem1779 {
    public static void main(String[] args) {

    }

    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE, ans = -1;
        for (int i = 0; i < points.length; i++) {
            if (x == points[i][0] || y == points[i][1]) {
                int d = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
                if (min > d) {
                    ans = i;
                    min = d;
                }
            }
        }
        return ans;
    }
}
