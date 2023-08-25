package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2347
 * @since 2023/2/20 0:52
 */
public class Problem2347 {
    public static void main(String[] args) {

    }

    public String bestHand(int[] ranks, char[] suits) {
        int[] cnts1 = new int[14], cnts2 = new int[5];
        int max1 = 0, max2 = 0;
        for (int rank : ranks) max1 = Math.max(max1, ++cnts1[rank]);
        for (char suit : suits) max2 = Math.max(max2, ++cnts2[suit - 'a']);
        if (max2 == 5) return "Flush";
        else if (max1 >= 3) return "Three of a Kind";
        else if (max1 == 2) return "Pair";
        return "High Card";
    }
}
