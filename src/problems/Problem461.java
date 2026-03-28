package problems;

public class Problem461 {

    public int hammingDistance(int x, int y) {
        int z = x ^ y, ans = 0;
        while (z != 0) {
            if ((z & 1) == 1) ans++;
            z >>>= 1;
        }
        return ans;
    }
}
