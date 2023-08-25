package bbc.y2021a;

import java.util.Scanner;

public class YanghuiTriangle { // TLE: 40%
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            long[][] arr = new long[2][];
            boolean f = true;
            for (int i = 0; f; i++) {
                arr[i & 1] = new long[i + 1];
                arr[i & 1][0] = arr[i & 1][i] = 1;
                for (int j = 1; j < i && f; j++) {
                    arr[i & 1][j] = arr[(i - 1) & 1][j - 1] + arr[(i - 1) & 1][j];
                    if (arr[i & 1][j] == n) {
                        System.out.println((i * (i + 1) / 2) + j + 1);
                        f = false;
                    }
                }
            }
        }
    }
}
