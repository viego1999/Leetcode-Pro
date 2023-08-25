package problems;

public class Problem6268 {
    public static void main(String[] args) {

    }

    public int[] cycleLengthQueries(int n, int[][] queries) {
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            int res = 1, a = queries[i][0], b = queries[i][1];
            while (a != b) {
                if (a > b) a /= 2;
                else b /= 2;
                ++res;
            }
            ans[i] = res;
        }
        return ans;
    }
}
