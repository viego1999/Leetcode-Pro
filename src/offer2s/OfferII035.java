package offer2s;

import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII035
 * @since 2023/4/29 16:58
 */
public class OfferII035 {
    public static void main(String[] args) {

    }

    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 24 * 60) return 0;
        timePoints.sort(String::compareTo);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < timePoints.size(); i++) {
            ans = Math.min(ans, getMinutes(timePoints.get(i)) - getMinutes(timePoints.get(i - 1)));
        }
        ans = Math.min(ans, getMinutes(timePoints.get(0)) + (24 * 60 - getMinutes(timePoints.get(timePoints.size() - 1))));
        return ans;
    }

    private int getMinutes(String time) {
        String[] strs = time.split(":");
        return Integer.parseInt(strs[0]) * 60 + Integer.parseInt(strs[1]);
    }
}
