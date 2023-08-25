package offer2s;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII110
 * @since 2023/5/26 21:05
 */
public class OfferII110 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, graph, 0, new ArrayList<>());
        return ans;
    }

    public void dfs(List<List<Integer>> ans, int[][] adjs, int u, List<Integer> list) {
        list.add(u);
        if (u == adjs.length - 1) {
            ans.add(new ArrayList<>(list));
        } else {
            for (int v : adjs[u]) {
                dfs(ans, adjs, v, list);
            }
        }
        list.remove(Integer.valueOf(u));
    }
}
