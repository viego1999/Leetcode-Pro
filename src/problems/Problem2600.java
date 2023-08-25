package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2600
 * @since 2023/7/5 23:15
 */
public class Problem2600 {
    public static void main(String[] args) {

    }

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        return Math.min(k, numOnes) - Math.max(0, k - numOnes - numZeros);
    }
}
