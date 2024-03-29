package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("all")
public class SortAndDivideConquer {
    public static void main(String[] args) {
        int[] nums = new int[]{8, 3, 2, 9, 7, 1, 5, 4, 6};
        merge_sort(nums, 0, nums.length - 1);
        System.out.println("merge sort: " + Arrays.toString(nums));
//
//        int[] nums1 = new int[]{20, 40, 30, 10, 60, 50, 5};
//        QuickSort(nums1, 0, nums1.length - 1);
//        System.out.println(Arrays.toString(nums1));
//
        int[] nums2 = new int[]{5, 3, 1, 9, 5, 8, 2, 4, 5, 7};
        quick_sort(nums2, 0, nums2.length - 1);
        System.out.println("quick sort: " + Arrays.toString(nums2));

//        int[] nums3 = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
//        quick_sort(nums3, 0, nums3.length - 1);
//        System.out.println(Arrays.toString(nums3));
//
//        int[] nums3 = new int[]{5, 3, 1, 9, 5, 8, 2, 4, 5, 7};
//        insertionSort(nums3);
//        System.out.println(Arrays.toString(nums3));
//
//        int[] nums4 = new int[]{26, 3, 49, 556, 81, 9, 863, 1, 10, 0};
//        radixSort(nums4);
//        System.out.println(Arrays.toString(nums4));
//
//        int[] nums5 = new int[]{26, 3, 49, 556, 81, 9, 863, 1, 10, 0};
//        countingSort(nums5);
//        System.out.println(Arrays.toString(nums5));
//
//        int[] nums6 = new int[]{26, 3, 49, 556, 81, 9, 863, 1, 10, 0};
//        bucketSort(nums6);
//        System.out.println(Arrays.toString(nums6));
//
//        int[] nums7 = new int[]{26, 3, 49, 556, 81, 9, 863, 1, 10, 0};
//        selectionSort(nums7);
//        System.out.println(Arrays.toString(nums7));

        int[] nums8 = {26, 3, 49, 556, 81, 9, 863, 1, 10, 0};
        heapSort(nums8);
        System.out.println("heap sort: " + Arrays.toString(nums8));
    }

    public static void mergeSort(int[] nums) {
        if (nums.length > 1) {
            int[] nums1 = Arrays.copyOf(nums, nums.length / 2);
            int[] nums2 = Arrays.copyOfRange(nums, nums.length / 2, nums.length);
            mergeSort(nums1);
            mergeSort(nums2);
            merge(nums, nums1, nums2);
        }
    }

    public static void merge(int[] nums, int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = 0;
        while (j < nums1.length && k < nums2.length) {
            if (nums1[j] < nums2[k]) nums[i++] = nums1[j++];
            else nums[i++] = nums2[k++];
        }

        if (j == nums1.length) {
            while (k < nums2.length) {
                nums[i++] = nums2[k++];
            }
        } else {
            while (j < nums1.length) {
                nums[i++] = nums1[j++];
            }
        }
    }

    public static void merge_sort(int[] nums, int l, int r) {
        if (l < r) {
            int m = l + r >> 1;
            merge_sort(nums, l, m);
            merge_sort(nums, m + 1, r);
            merge(nums, l, m, r);
        }
    }

    public static void merge(int[] nums, int l, int m, int r) {
        int i = l, j = m + 1, k = 0;
        int[] temp = new int[r - l + 1];
        while (i <= m || j <= r) {
            if (i <= m && j <= r) {
                if (nums[i] < nums[j]) temp[k++] = nums[i++];
                else temp[k++] = nums[j++];
            } else if (i <= m) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }
        for (i = l, j = 0; i <= r; i++, j++) nums[i] = temp[j];
    }

    /*
        5, 3, 1, 9, 8, 2, 4, 7

        5, 3, 1, 4, 8, 2, 9, 7
        5, 3, 1, 4, 2, 8, 9, 7
                    j  i

        2, 3, 1, 4, 5, 8, 9, 7
                    *
     */
    public static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int s = partition(nums, low, high);
            quickSort(nums, low, s - 1);
            quickSort(nums, s + 1, high);
        }
    }

    public static int partition(int[] nums, int low, int high) {
        int p = nums[low];
        int i = low, j = high;

        while (i < j) {
            while (nums[j] > p && i < j) j--;
            while (nums[i] <= p && i < j) i++;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        nums[low] = nums[j];
        nums[j] = p;
        return j;
    }

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }

            }
        }
    }

    /*
        8, 3, 2, 9, 7, 1, 5, 4, 6
     */
    public static void QuickSort(int[] a, int start, int end) {
        if (start >= end) return;
        int s = start, e = end;
        int pivot = a[s];
        while (s < e) {
            while (a[e] > pivot && e > s) e--;
            while (a[s] <= pivot && s < e) s++;
            int temp = a[e];
            a[e] = a[s];
            a[s] = temp;
        }
        a[start] = a[e];
        a[e] = pivot;
        QuickSort(a, start, e - 1);
        QuickSort(a, e + 1, end);
    }

    public static void selectionSort(int[] nums) {
        // 每次选择一个最小的数放在最前面
        for (int i = 0; i < nums.length - 1; i++) { // 交换次数
            int min = i; // 先假设每次循环时，最小数的索引为i
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) min = j;
            }
            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }
    }

    /*
        8, 3, 2, 9, 7, 1, 5, 4, 6
     */
    public static void insertionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 此时[0,i-1]是已经排好序的数组
            for (int j = i; j > 0; j--) { // 寻找元素nums[i]的插入位置
                if (nums[j] < nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                } else break;
            }
        }
    }

    public static void bucketSort(int[] nums) {
        int maxV = Arrays.stream(nums).max().getAsInt();
        int minV = Arrays.stream(nums).min().getAsInt();
        int n = nums.length;
//        int d = Math.max(1, (maxV - minV) / (n - 1));
//        int bucketSize = (maxV - minV) / d + 1;
        int bucketNum = (maxV - minV) / n + 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new ArrayList<>());
        }
        // 将每个元素放入桶内
        for (int i = 0; i < n; i++) {
            int num = (nums[i] - minV) / n;
            buckets.get(num).add(nums[i]);
        }
        // 对每个桶进行排序
        for (int i = 0; i < buckets.size(); i++) {
            Collections.sort(buckets.get(i));
        }
        // 将桶中元素赋值到原数组
        int idx = 0;
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                nums[idx++] = num;
            }
        }
    }

    /*
        1、排序数组的索引值与 counts[]总的计数 存在关系
        2、排序数组的值 与 counts[]中的桶序号 存在关系
        根据1、2关系，可以通过 counts[] 来 得到 temps[]
        nums = [26, 3, 49, 556, 81, 9, 863, 1, 10, 0]
     */
    public static void radixSort(int[] nums) {
        // 寻找数组中最大数，为了知道循环几次
        int max = Arrays.stream(nums).max().getAsInt();
        // 计算最大位数
        int maxLen = max > 0 ? (max + "").length() : (max + "").length() + 1;
        // 用于临时存储数据的数组
        int[] temps = new int[nums.length];
        // 用于存储桶内元素的位置
        int[] counts = new int[10]; // 存放余数
        int radix = 1;
        for (int i = 0; i < maxLen; i++) { // 进行最大位次数排序 （或 while (max >= radix) {）
            // 每次分配前清空计数器
            Arrays.fill(counts, 0);
            for (int j = 0; j < nums.length; j++) {
                int k = (nums[j] / radix) % 10; // 统计每个桶中的记录数
                counts[k]++;
            }
//            System.out.println("counts1: " + Arrays.toString(counts));
            for (int j = 1; j < 10; j++) { // 目的是让更改后的 counts[i] 的值，是该数据在 temps[] 中的位置
                // 从当前位置开始前面共有几个元素，即在该位置时总共有几个元素。
                counts[j] = counts[j - 1] + counts[j]; //将tmp中的位置依次分配给每个桶
            }
//            System.out.println("counts2: " + Arrays.toString(counts));
            // 将所有桶中记录依次收集到tmp中
            for (int j = nums.length - 1; j >= 0; j--) {
                int k = (nums[j] / radix) % 10;
                temps[counts[k] - 1] = nums[j]; // 索引从0开始，故由 个数 - 1.
                counts[k]--;
            }
//            System.out.println("temps: " + Arrays.toString(temps));
            // 将临时数组的内容复制到data中
            for (int j = 0; j < nums.length; j++) nums[j] = temps[j];
            radix *= 10;
        }
    }

    public static void countingSort(int[] nums) {
        int maxV = Arrays.stream(nums).max().orElse(-1);
        int[] buckets = new int[maxV + 1];
        for (int num : nums) {
            buckets[num]++;
        }
        int idx = 0;
        for (int i = 0; i < buckets.length; i++) {
            while (buckets[i] > 0) {
                nums[idx++] = i;
                buckets[i]--;
            }
        }
    }

    // 5, 3, 1, 9, 5, 8, 2, 4, 5, 7
    // 5, 3, 1, 5, 5, 8, 2, 4, 9, 7
    // 5, 3, 1, 5, 5, 4, 2, 8, 9, 7
    // 2, 3, 1, 5, 5, 4, 5, 8, 9, 7
    // 2, 1, 3, 5, 5, 4
    // 1, 2, 3, 5, 5, 4
    public static void quick_sort(int[] nums, int left, int right) {
        if (left < right) {
            int s = partition_(nums, left, right);
            quick_sort(nums, left, s - 1);
            quick_sort(nums, s + 1, right);
        }
    }

    // 每次保证s位置的右边都是大于pivot，s的左边都是小于等于pivot
    public static int partition_(int[] nums, int left, int right) {
        int povit = nums[left];
        int i = left, j = right; // i从l开始，比如[3,5,4]
        while (i < j) {
            while (i < j && nums[j] > povit) j--;
            while (i < j && nums[i] <= povit) i++;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        // 交换中轴l与j的值
        nums[left] = nums[j];
        nums[j] = povit;
        return j;
    }

    // https://blog.csdn.net/kingmax54212008/article/details/105476590
    public static void heapSort(int[] nums) {
        for (int i = nums.length - 1; i >= 1; i--) {
            buildHeap(nums, i);
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
        }
    }

    public static void buildHeap(int[] nums, int end) {
        int len = end + 1;
        // 元素从0开始，因此最后一个非叶子节点为 len / 2 - 1
        for (int i = len / 2 - 1; i >= 0; i--) {
            // 堆中i节点对应的左右子节点 l 和 r
            int l = 2 * i + 1, r = l + 1;
            // 指向较大数节点的指针
            int p = l;
            if (r < len && nums[l] < nums[r]) p = r;
            if (nums[i] < nums[p]) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
            }
        }
    }
}
