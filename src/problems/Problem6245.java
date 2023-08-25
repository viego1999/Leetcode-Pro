package problems;

public class Problem6245 {
    public static void main(String[] args) {

    }

    public int pivotInteger(int n) {
        int sum = (n + 1) * n / 2, x = (int) Math.sqrt(sum);
        return x * x == sum ? x : -1;
    }

    public int pivotInteger_(int n) {
        int sum = (n + 1) * n / 2, t = 0;
        for (int i = 1; i <= n; i++) {
            t += i;
            if (t == sum) return i;
            sum -= i;
        }
        return -1;
    }
}
