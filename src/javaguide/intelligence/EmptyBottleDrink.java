package javaguide.intelligence;

public class EmptyBottleDrink {
    public static void main(String[] args) {
        System.out.println(solve(1000, 3));
    }

    /**
     * 拿走3瓶，换回1瓶，相当于减少2瓶。但是最后剩下4瓶的时候例外，这时只能换1瓶。所以我们计算1000减2能减多少次，
     * 直到剩下4.（1000-4=996，996/2=498）所以1000减2能减498次直到剩下4瓶，最后剩下的4瓶还可以换一瓶，所以总共是1000+498+1=1499瓶。
     *
     * @param nums 总共饮料个数
     * @param m    m个空瓶可换一瓶饮料
     * @return 最多能喝几瓶饮料
     */
    public static int solve(int nums, int m) {
        int ans = nums, empty = nums;
        while (empty >= m) {
            int k = empty / m, rest = empty % m;
            ans += k;
            empty = k + rest;
        }
        return ans;
    }
}
