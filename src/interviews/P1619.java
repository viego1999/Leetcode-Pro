package interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName P1619
 * @since 2023/6/23 23:02
 */
public class P1619 {
    public static void main(String[] args) {

    }

    public int[] pondSizes(int[][] land) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    ans.add(dfs(land, i, j));
                }
            }
        }
        int[] arr = new int[ans.size()];
        for (int i = 0; i < arr.length; i++) arr[i] = ans.get(i);
        Arrays.sort(arr);
        return arr;
    }

    public int dfs(int[][] land, int i, int j) {
        if (i < 0 || i >= land.length || j < 0 || j >= land[0].length || land[i][j] != 0) return 0;
        land[i][j] = -1;
        return 1 + dfs(land, i - 1, j) + dfs(land, i + 1, j) + dfs(land, i, j - 1) + dfs(land, i, j + 1) + dfs(land, i - 1, j - 1) + dfs(land, i - 1, j + 1) + dfs(land, i + 1, j - 1) + dfs(land, i + 1, j + 1);
    }
}
