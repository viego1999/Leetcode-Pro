package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1015
 * @since 2023/5/10 12:58
 */
public class Problem1015 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] str = scan.nextLine().split(" ");
        int a = scan.nextInt(), b = scan.nextInt();
        System.out.println(Arrays.toString(str));
        System.out.println(a + b);
    }

    public int smallestRepunitDivByK(int k) {
        Set<Integer> set = new HashSet<>();
        int ans = 1, r = 1 % k;
        set.add(r);
        while (r > 0) {
            r = (r * 10 + 1) % k;
            if (!set.add(r)) return -1;
            ans++;
        }
        return ans;
    }
}
