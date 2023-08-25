package problems;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Problem6242 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createBinaryTree(Arrays.asList(6, 2, 1, null, null, 4, null, null, 13, 9, null, null, 15, 14, null, null));
        System.out.println(closestNodes(root, Arrays.asList(2, 5, 16)));
        System.out.println(closestNodesSet(root, Arrays.asList(2, 5, 16)));
    }

    public static List<List<Integer>> closestNodesSet(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        dfsSet(root, set);
        for (int q : queries) {
            Integer a = set.floor(q), b = set.ceiling(q);
            ans.add(Arrays.asList(a == null ? -1 : a, b == null ? -1 : b));
        }
        return ans;
    }

    public static void dfsSet(TreeNode root, TreeSet<Integer> set) {
        if (root == null) return;
        dfsSet(root.left, set);
        set.add(root.val);
        dfsSet(root.right, set);
    }

    public static List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        Integer[] arr = list.toArray(new Integer[0]);
        List<List<Integer>> ans = new ArrayList<>();
        System.out.println(Arrays.toString(arr));
        for (Integer q : queries) {
            ans.add(Arrays.asList(findMin(arr, q), findMax(arr, q)));
        }
        return ans;
    }

    public static void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    /**
     * 找有序数组 arr 中最后一个比 k 小的数
     *
     * @param arr 有序数组
     * @param k   目标数 k
     * @return 返回最后一个比 k 小的数，若不存在返回 -1
     */
    public static int findMin(Integer[] arr, int k) {
        int l = 0, r = arr.length - 1;
        if (arr[0] > k) return -1;
        while (l < r) {
            int m = (l + r + 1) >> 1;
            if (arr[m] > k) r = m - 1;
            else if (arr[m] == k) return arr[m];
            else l = m;
        }
        return arr[l];
    }

    /**
     * 找有序数组 arr 中第一个比 k 大的数
     *
     * @param arr 有序数组
     * @param k   目标数 k
     * @return 返回第一个比 k 大的数，若不存在返回 -1
     */
    public static int findMax(Integer[] arr, int k) {
        int l = 0, r = arr.length - 1;
        if (arr[r] < k) return -1;
        while (l < r) {
            int m = l + r >> 1;
            if (arr[m] > k) r = m;
            else if (arr[m] == k) return arr[m];
            else l = m + 1;
        }
        return arr[l];
    }
}
