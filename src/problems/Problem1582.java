package problems;

public class Problem1582 {
    public static void main(String[] args) {

    }

    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length, ans = 0;
        int[]sumx = new int[m], sumy = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sumx[i] += mat[i][j];
                sumy[j] += mat[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && sumx[i] == 1 && sumy[j] == 1) ans++;
            }
        }
        return ans;
    }
}
