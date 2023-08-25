package problems;

import java.util.Arrays;

public class Problem670 {
    public static void main(String[] args) {

    }

    public int maximumSwap(int num) {
        char[] cs = String.valueOf(num).toCharArray();
        int n = cs.length, max = n - 1;
        int[] maxIdx = new int[n]; // 记录每个数从当前位置往右的最大值索引
        for (int i = n - 1; i >= 0; i--) {
            if (cs[i] > cs[max]) max = i;
            maxIdx[i] = max;
        }
        for (int i = 0; i < n; i++) { // 从前往后找到第一个最大值不是自己本身的数
            if (cs[i] != cs[maxIdx[i]]) {
                char tmp = cs[i];
                cs[i] = cs[maxIdx[i]];
                cs[maxIdx[i]] = tmp;
                return Integer.parseInt(new String(cs));
            }
        }
        return num;
    }

    public int maximumSwap_(int num) {
        char[] cs = String.valueOf(num).toCharArray();
        for (int i = 0, n = cs.length; i < n; i++) {
            int maxIdx = i;
            for (int j = n - 1; j > i; j--) maxIdx = cs[maxIdx] < cs[j] ? j : maxIdx;
            if (maxIdx > i) {
                char tmp = cs[maxIdx];
                cs[maxIdx] = cs[i];
                cs[i] = tmp;
                return Integer.parseInt(new String(cs));
            }
        }
        return num;
    }

    public int maximumSwap__(int num) {
        char[] cs = String.valueOf(num).toCharArray(), tp = cs.clone();
        Arrays.sort(cs);
        for (int i = 0, n = cs.length; i < n; i++) {
            if (cs[n - i - 1] != tp[i]) {
                for (int j = n - 1; j > i; j--) {
                    if (cs[n - i - 1] == tp[j]) {
                        tp[j] = tp[i];
                        tp[i] = cs[n - i - 1];
                        return Integer.parseInt(new String(tp));
                    }
                }
            }
        }
        return num;
    }
}
