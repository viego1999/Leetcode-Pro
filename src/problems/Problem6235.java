package problems;

import util.TreeNode;

import java.util.*;

// 6233 6234 6235 6236
public class Problem6235 {
    public static void main(String[] args) {
        // [347, 167, 383, 422, 493, 489, 275, 72, 425, 89]
        // [162, 18, 363, 290, 106, 260, 468, 432, 323]
    }

    // 7,4,2,1,6,5,3
    // 1,2,3,4,5,6,7
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        int ans = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] arr = new int[size], temp = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                arr[i] = temp[i] = cur.val;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            Map<Integer, Integer> map = new HashMap<>();
            Arrays.sort(temp);
            for (int i = 0; i < arr.length; i++) map.put(temp[i], i);
            for (int i = 0; i < arr.length; i++) {
                while (arr[i] != temp[i]) {
                    int j = map.get(arr[i]);
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                    ans++;
                }
            }
        }
        return ans;
    }

    public int minimumOperations_(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        int ans = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                arr[i] = cur.val;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            ans += function(arr, 0, size - 1);
        }
        return ans;
    }

    // 每次都将最大的数放在最后，然后缩小范围
    // O(n^2)
    public static int function(int[] arr, int left, int right) {
        if (left == right) return 0;
        int max = Integer.MIN_VALUE, i = left, j = -1; // j 最大值所在的索引
        while (i <= right) {
            if (arr[i] > max) {
                max = arr[i];
                j = i;
            }
            i++;
        }
        if (max == arr[right]) {
            return function(arr, left, right - 1);
        } else {
            int temp = arr[j];
            arr[j] = arr[right];
            arr[right] = temp;
            return 1 + function(arr, left, right - 1);
        }
    }
}
