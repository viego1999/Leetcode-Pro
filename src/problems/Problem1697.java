package problems;

import java.util.Arrays;

public class Problem1697 {
    public static void main(String[] args) {

    }

    int[] fa;

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (x, y) -> x[2] - y[2]);
        fa = new int[n];
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < n; i++) fa[i] = i;
        Integer[] qid = new Integer[queries.length];
        for (int i = 0; i < qid.length; i++) qid[i] = i;
        Arrays.sort(qid, (x, y) -> queries[x][2] - queries[y][2]);
        int j = 0;
        for (int i : qid) {
            int x = queries[i][0], y = queries[i][1], k = queries[i][2];
            while (j < edgeList.length && edgeList[j][2] < k) {
                meger(edgeList[j][0], edgeList[j][1]);
                j++;
            }
            ans[i] = find(x) == find(y);
        }
        return ans;
    }

    public int find(int x) {
        if (x == fa[x]) return x;
        return fa[x] = find(fa[x]);
    }

    public void meger(int x, int y) {
        fa[find(y)] = find(x);
    }
}
