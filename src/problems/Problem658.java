package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 658. 找到 K 个最接近的元素
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 *
 * 整数 a 比整数 b 更接近 x 需要满足：
 *
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 *
 *
 * 提示：
 *
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 104
 * arr 按 升序 排列
 * -104 <= arr[i], x <= 104
 *
 * link: https://leetcode.cn/problems/find-k-closest-elements/
 */
public class Problem658 {
    public static void main(String[] args) {

    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length, r = binarySearch(arr, x), l = r - 1;
        List<Integer> ans = new ArrayList<>();
        while (k-- > 0) {
            if (l >= 0 && r < n) {
                if (x - arr[l] <= arr[r] - x) l--;
                else r++;
            } else if (l >= 0) l--;
            else r++;
        }
        for (int i = ++l; i < r; i++) ans.add(arr[i]);
        return ans;
    }

    public int binarySearch(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + r >> 1;
            if (arr[m] < x) l = m + 1;
            else r = m;
        }
        return l;
    }

    public List<Integer> findClosestElements_(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) list.add(num);
        list.sort((a, b) -> {
            int i = Math.abs(a - x), j = Math.abs(b - x);
            if (i != j) return i - j;
            else return a - b;
        });
        List<Integer> ans = list.subList(0, k);
        ans.sort((a, b) -> a - b);
        return ans;
    }
}
