package problems;

public class Problem1640 {
    public static void main(String[] args) {

    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[] hash = new int[101];
        int n = arr.length, s = 0;
        for (int i = 0; i < n; i++) hash[arr[i]] = i + 1;
        for (int[] piece : pieces) {
            if ((s = hash[piece[0]]) == 0) return false; // piece起始索引
            for (int i = 0; i < piece.length; i++) {
                if (hash[piece[i]] != s + i) return false;
            }
        }
        return true;
    }
}
