package problems;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem2446
 * @since 2023/5/17 10:33
 */
public class Problem2446 {
    public static void main(String[] args) {

    }

    public boolean haveConflict(String[] event1, String[] event2) {
        return event1[0].compareTo(event2[0]) <= 0 ? event1[1].compareTo(event2[0]) >= 0 : event2[1].compareTo(event1[0]) >= 0;
    }
}
