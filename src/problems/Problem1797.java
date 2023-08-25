package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem1797
 * @since 2023/2/9 0:04
 */
public class Problem1797 {
    public static void main(String[] args) {

    }

    /**
     * Your AuthenticationManager object will be instantiated and called as such:
     * AuthenticationManager obj = new AuthenticationManager(timeToLive);
     * obj.generate(tokenId,currentTime);
     * obj.renew(tokenId,currentTime);
     * int param_3 = obj.countUnexpiredTokens(currentTime);
     */
    static class AuthenticationManager {
        Map<String, Integer> map = new HashMap<>();
        int timeToLive;

        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
        }

        public void generate(String tokenId, int currentTime) {
            map.put(tokenId, currentTime + timeToLive);
        }

        public void renew(String tokenId, int currentTime) {
            if (map.getOrDefault(tokenId, 0) > currentTime) map.put(tokenId, currentTime + timeToLive);
        }

        public int countUnexpiredTokens(int currentTime) {
            int cnt = 0;
            for (Integer time : map.values()) if (time > currentTime) cnt++;
            return cnt;
        }
    }
}
