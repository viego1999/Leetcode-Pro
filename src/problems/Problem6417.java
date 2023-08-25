package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName Problem6417
 * @since 2023/5/7 12:23
 */
public class Problem6417 {
    public static void main(String[] args) {

    }

    /**
     * Your FrequencyTracker object will be instantiated and called as such:
     * FrequencyTracker obj = new FrequencyTracker();
     * obj.add(number);
     * obj.deleteOne(number);
     * boolean param_3 = obj.hasFrequency(frequency);
     */
    static class FrequencyTracker {
        Map<Integer, Integer> nums = new HashMap<>(), freqs = new HashMap<>();

        public FrequencyTracker() {

        }

        public void add(int number) {
            int f = nums.getOrDefault(number, 0);
            if (f > 0) {
                int t = freqs.getOrDefault(f, 0);
                if (t == 1) freqs.remove(f);
                else freqs.put(f, t - 1);
            }
            nums.put(number, f + 1);
            freqs.put(f + 1,freqs.getOrDefault(f + 1, 0) + 1);
        }

        public void deleteOne(int number) {
            Integer f = nums.get(number);
            if (f != null) {
                if (f == 1) nums.remove(number);
                else nums.put(number, f - 1);

                int t = freqs.getOrDefault(f, 0);
                if (t == 1) freqs.remove(f);
                else freqs.put(f, t - 1);
                freqs.put(f - 1, freqs.getOrDefault(f - 1, 0) + 1);
            }
        }

        public boolean hasFrequency(int frequency) {
            return freqs.containsKey(frequency);
        }
    }
}
