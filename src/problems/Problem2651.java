package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2651
 * @since 2023/9/8 18:26
 */
public class Problem2651 {
    public static void main(String[] args) {

    }

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
