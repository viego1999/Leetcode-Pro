package problems;

public class Problem1652 {
    public static void main(String[] args) {

    }

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        if (k == 0) return new int[n];
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) sums[i] = sums[i - 1] + code[i - 1];
        for (int i = 0; i < n; i++) {
            if (k > 0) code[i] = i + k < n ? sums[i + k + 1] - sums[i + 1] : sums[n] - sums[i + 1] + sums[k - n + i + 1];
            else code[i] = i < -k ? sums[i] + sums[n] - sums[n + k + i] : sums[i] - sums[i + k];
        }
        return code;
    }
}
