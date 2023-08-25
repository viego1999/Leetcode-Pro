package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem771
 * @since 2023/7/24 0:40
 */
public class Problem771 {
    public static void main(String[] args) {

    }

    public int numJewelsInStones(String jewels, String stones) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (char c : jewels.toCharArray()) set.add(c);
        for (char c : stones.toCharArray()) if (set.contains(c)) ans++;
        return ans;
    }
}
