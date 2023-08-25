package problems;

/**
 * 780. 到达终点
 * 给定四个整数 sx , sy ，tx 和 ty，如果通过一系列的转换可以从起点 (sx, sy) 到达终点 (tx, ty)，则返回 true，否则返回 false。
 *
 * 从点 (x, y) 可以转换到 (x, x+y)  或者 (x+y, y)。
 *
 *
 *
 * 示例 1:
 *
 * 输入: sx = 1, sy = 1, tx = 3, ty = 5
 * 输出: true
 * 解释:
 * 可以通过以下一系列转换从起点转换到终点：
 * (1, 1) -> (1, 2)
 * (1, 2) -> (3, 2)
 * (3, 2) -> (3, 5)
 * 示例 2:
 *
 * 输入: sx = 1, sy = 1, tx = 2, ty = 2
 * 输出: false
 * 示例 3:
 *
 * 输入: sx = 1, sy = 1, tx = 1, ty = 1
 * 输出: true
 *
 *
 * 提示:
 *
 * 1 <= sx, sy, tx, ty <= 109
 *
 * link: https://leetcode-cn.com/problems/reaching-points/
 */
public class Problem780 {
    public static void main(String[] args) {

    }

    /**
     * 给定的 (sx,sy) 的数据范围为 [1, 10^9]（即均为正整数），且每次转换，只能将另外一维的数值累加到当前维，因此对于每一维的数值而言，随着转换次数的进行，呈（非严格）递增趋势，再结合起始值为正整数，可知在转换过程中均不会出现负数。
     * <p>
     * 由此得知从(tx,ty) 到 (sx,sy) 的转换过程唯一确定：总是取较大数减去较小数来进行反推（否则会出现负数）。
     * <p>
     * 但即使反向转换唯一确定，数据范围为 10^9，线性模拟仍会超时。
     * <p>
     * 我们考虑将「相同操作的连续段转换动作」进行合并，在某次反向转换中，如果有 tx<ty，我们会将 (tx,ty) 转换为 (tx,ty−tx)，若相减完仍有 tx<ty−tx，该操作会继续进行，得到 (tx,ty−2∗tx)，直到不满足 tx<ty−k∗tx，其中 k 为转换次数。
     * <p>
     * 即对于一般性的情况而言，(tx,ty) 中的较大数会一直消减到「与较小数的余数」为止。
     * <p>
     * 因此我们可以先使用 O(logmax(tx,ty)) 的复杂度将其消减到不超过 (sx,sy) 为止。此时如果消减后的结果 (tx,ty) 任一维度小于 (sx,sy)，必然不能进行转换，返回 False；如果任一维度相等（假定是 x 维度），则检查另一维度（y 维度）的差值，是否能够由当前维度（x 维度）拼凑而来。
     */
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy) {
            if (tx > ty) tx %= ty;
            else ty %= tx;
        }
        if (tx < sx || ty < sy) return false;
        if (tx == sx) return (ty - sy) % sx == 0;
        else return (tx - sx) % sy == 0;
    }
}
