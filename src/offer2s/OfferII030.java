package offer2s;

import java.util.*;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII030
 * @since 2023/4/25 21:03
 */
public class OfferII030 {
    public static void main(String[] args) {

    }

    /**
     * Your RandomizedSet object will be instantiated and called as such:
     * <pre>{@code
     *      RandomizedSet obj = new RandomizedSet();
     *      boolean param_1 = obj.insert(val);
     *      boolean param_2 = obj.remove(val);
     *      int param_3 = obj.getRandom();
     * }</pre>
     */
    static class RandomizedSet {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> nums = new ArrayList<>();
        Random random = new Random();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {

        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            nums.add(val);
            map.put(val, nums.size() - 1);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            int last = nums.get(nums.size() - 1), idx = map.get(val);
            nums.set(idx, last);
            nums.remove(nums.size() - 1);
            map.put(last, idx);
            map.remove(val);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return nums.get(random.nextInt(nums.size()));
        }
    }
}
