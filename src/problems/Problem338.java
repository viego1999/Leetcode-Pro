package problems;

public class Problem338 {

    /**
     * 对于正整数 x，将其二进制表示右移一位，等价于将其二进制表示的最低位去掉，得到的数是 ⌊
     * 2
     * x
     * ​
     *  ⌋。如果 bits[⌊
     * 2
     * x
     * ​
     *  ⌋] 的值已知，则可以得到 bits[x] 的值：
     *
     * 如果 x 是偶数，则 bits[x]=bits[⌊
     * 2
     * x
     * ​
     *  ⌋]；
     * 如果 x 是奇数，则 bits[x]=bits[⌊
     * 2
     * x
     * ​
     *  ⌋]+1。
     * 上述两种情况可以合并成：bits[x] 的值等于 bits[⌊
     * 2
     * x
     * ​
     *  ⌋] 的值加上 x 除以 2 的余数。
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}
