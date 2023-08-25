package offer2s;

import java.util.TreeMap;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII058
 * @since 2023/5/7 10:17
 */
public class OfferII058 {
    public static void main(String[] args) {

    }

    static class MyCalendar {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            Integer floor = map.floorKey(start), ceil = map.ceilingKey(start);
            if ((floor == null || map.get(floor) <= start) && (ceil == null || ceil >= end)) {
                map.put(start, end);
                return true;
            }
            return false;
        }
    }
}
