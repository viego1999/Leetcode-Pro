package problems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem1753 {
    public static void main(String[] args) {

    }

    /*
    如果c>=a+b，很容易知道我们最多只能把a,b的石头全部匹配完，因此返回a+b即可
    如果a+b>c，为了让石头尽可能多匹配几次。我们先让a和b去匹配，一旦a+b的和小于c的时候，就可以用c把他们全部匹配掉。
    */
    public int maximumScore(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        if (arr[0] + arr[1] <= arr[2]) return arr[0] + arr[1];
        return (a + b + c) / 2;
    }

    public  int maximumScore__(int a, int b, int c) {
        int ans = 0;
        int[] arr = {a, b, c};
        while (true) {
            Arrays.sort(arr);
            if (arr[1] == 0) break;
            arr[1]--;
            arr[2]--;
            ans++;
        }
        return ans;
    }

    public int maximumScore_(int a, int b, int c) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        pq.addAll(Arrays.asList(a, b, c));
        while (pq.size() > 1) {
            int i = pq.poll(), j = pq.poll();
            if (--i > 0) pq.offer(i);
            if (--j > 0) pq.offer(j);
            ans++;
        }
        return ans;
    }
}
