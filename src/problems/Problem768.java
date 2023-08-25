package problems;

import java.util.*;

/**
 * 768. 最多能完成排序的块 II
 * 这个问题和“最多能完成排序的块”相似，但给定数组中的元素可以重复，输入数组最大长度为2000，其中的元素最大为10**8。
 *
 * arr是一个可能包含重复元素的整数数组，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
 *
 * 我们最多能将数组分成多少块？
 *
 * 示例 1:
 *
 * 输入: arr = [5,4,3,2,1]
 * 输出: 1
 * 解释:
 * 将数组分成2块或者更多块，都无法得到所需的结果。
 * 例如，分成 [5, 4], [3, 2, 1] 的结果是 [4, 5, 1, 2, 3]，这不是有序的数组。
 * 示例 2:
 *
 * 输入: arr = [2,1,3,4,4]
 * 输出: 4
 * 解释:
 * 我们可以把它分成两块，例如 [2, 1], [3, 4, 4]。
 * 然而，分成 [2, 1], [3], [4], [4] 可以得到最多的块数。
 * 注意:
 *
 * arr的长度在[1, 2000]之间。
 * arr[i]的大小在[0, 10**8]之间。
 *
 * link: https://leetcode.cn/problems/max-chunks-to-make-sorted-ii/
 */
public class Problem768 {
    public static void main(String[] args) {

    }

    public int maxChunksToSortedStack(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : arr) {
            if (!stack.isEmpty() && num < stack.peek()) {
                int top = stack.pop();
                while (!stack.isEmpty() && num < stack.peek()) stack.pop();
                stack.push(top);
            } else stack.push(num);
        }
        return stack.size();
    }

    public int maxChunksToSortedDp(int[] arr) {
        int n = arr.length, ans = 0;
        int[] maxLeft = new int[n], minRight = new int[n];
        maxLeft[0] = arr[0];
        for (int i = 1; i < n; i++) maxLeft[i] = Math.max(maxLeft[i - 1], arr[i]);
        minRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) minRight[i] = Math.min(minRight[i + 1], arr[i]);
        for (int i = 0; i < n - 1; i++) {
            if (maxLeft[i] <= minRight[i + 1]) { // 左边部分最大值小于等于右边部分最小值
                ans++;
            }
        }
        return ans + 1;
    }

    // 2 5 3 1 4
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length, ans = 0;
        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        Map<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map1.put(tmp[i], map1.getOrDefault(tmp[i], 0) + 1);
            map2.put(arr[i], map2.getOrDefault(arr[i], 0) + 1);
            if (map1.equals(map2)) ans++;
        }
        return ans;
    }

    public int maxChunksToSorted_(int[] arr) {
        int n = arr.length, ans = 0, sum1 = 0, sum2 = 0;
        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        for (int i = 0; i < n; i++) {
            if ((sum1 += tmp[i]) == (sum2 += arr[i])) ans++;
        }
        return ans;
    }
}
