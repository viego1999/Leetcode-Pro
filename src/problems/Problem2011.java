package problems;

public class Problem2011 {
    public static void main(String[] args) {

    }

    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String operation : operations) {
            ans += operation.charAt(1) == '+' ? 1 : -1;
        }
        return ans;
    }
}
