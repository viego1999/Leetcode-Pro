package problems;

public class Problem2180 {

    public static void main(String[] args) {

    }

    public int countEven(int num) {
        int ans = 0;
        while (num > 1) {
            int n = num--, t = 0;
            while (n > 0) {
                t += n % 10;
                n /= 10;
            }
            if ((t & 1) == 0) ans++;
        }
        return ans;
    }

}
