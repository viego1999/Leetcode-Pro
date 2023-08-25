package problems;

public class Problem1785 {
    public static void main(String[] args) {

    }

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) sum += num;
        sum = Math.abs(sum - goal);
        return (int) Math.ceil(sum / (double) limit);
    }
}
