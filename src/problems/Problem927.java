package problems;

public class Problem927 {
    public static void main(String[] args) {

    }

    public int[] threeEqualParts(int[] arr) {
        int cnt = 0, n = arr.length;
        for (int k : arr) if (k == 1) ++cnt;
        if (cnt % 3 != 0) return new int[]{-1, -1};
        if (cnt == 0) return new int[]{0, 2};
        // 每段1的个数，s1-s3分别表示每一段1的起始位置
        int avg = cnt / 3, s1 = -1, s2 = -1, s3 = -1;
        for (int i = 0, j = 0, f = -1; i < n && f == -1; i++) {
            if (arr[i] == 1) {
                if (j++ % avg == 0) {
                    if (s1 == -1) s1 = i;
                    else if (s2 == -1) s2 = i;
                    else s3 = f = i;
                }
            }
        }
        // 同时遍历三段，当对应位置的值不相等时，表明不能等分
        while (s3 < n) {
            if (arr[s1++] != arr[s2] || arr[s2++] != arr[s3++])
                return new int[]{-1, -1};
        }
        return new int[]{s1 - 1, s2};
    }
}
