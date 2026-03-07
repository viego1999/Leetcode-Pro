package javaguide.ds.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 排序算法
 *
 * @author Wuxy
 * @version 1.0
 * @ClassName Sort
 * @since 2023/8/30 13:06
 */
public class Sort {
    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 1, 1, 9, 5, 8, 6};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
        shuffle(nums);
        System.out.println(Arrays.toString(nums));

        double a = 0.1, b = 0.2, c = 0.3, d = 0.4;
        System.out.println(a + b == c);
        System.out.println(a + c == d);

        int[] array = new int[]{3, 1, 5, 2, 9, 8, 2, 1};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void heapSort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            buildHeap(nums, i); // 每次把最大的数放到第0号元素
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
        }
    }

    // 构建大顶堆
    public static void buildHeap(int[] nums, int end) {
        // 从第一个非叶子节点向上调整
        for (int i = (end - 1) >> 1; i >= 0; i--) {
            int l = i * 2 + 1, r = l + 1, p = l;
            if (r <= end && nums[l] < nums[r]) p = r;
            if (nums[i] < nums[p]) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
            }
        }
    }

    public static void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int s = partition(nums, l, r);
            quickSort(nums, l, s - 1);
            quickSort(nums, s + 1, r);
        }
    }

    public static int partition(int[] nums, int l, int r) {
        int p = nums[l];
        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] > p) j--;
            while (i < j && nums[i] <= p) i++;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        nums[l] = nums[j];
        nums[j] = p;
        return j;
    }

    static void shuffle(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        Collections.shuffle(list);
        for (int i = 0; i < nums.length; i++) nums[i] = list.get(i);
    }
}
