package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1828
 * @since 2023/1/25 10:39
 */
public class Problem1828 {

    public static void main(String[] args) {

    }

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int[] point : points)
                if (((queries[i][0] - point[0]) * (queries[i][0] - point[0]) + (queries[i][1] - point[1]) * (queries[i][1] - point[1]) <= queries[i][2] * queries[i][2]))
                    ans[i]++;
        }
        return ans;
    }

}
