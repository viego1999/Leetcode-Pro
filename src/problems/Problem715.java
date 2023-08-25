package problems;

/**
 * 715. Range 模块
 * Range模块是跟踪数字范围的模块。设计一个数据结构来跟踪表示为 半开区间 的范围并查询它们。
 *
 * 半开区间 [left, right) 表示所有 left <= x < right 的实数 x 。
 *
 * 实现 RangeModule 类:
 *
 * RangeModule() 初始化数据结构的对象。
 * void addRange(int left, int right) 添加 半开区间 [left, right)，跟踪该区间中的每个实数。添加与当前跟踪的数字部分重叠的区间时，应当添加在区间 [left, right) 中尚未跟踪的任何数字到该区间中。
 * boolean queryRange(int left, int right) 只有在当前正在跟踪区间 [left, right) 中的每一个实数时，才返回 true ，否则返回 false 。
 * void removeRange(int left, int right) 停止跟踪 半开区间 [left, right) 中当前正在跟踪的每个实数。
 *
 *
 * 示例 1：
 *
 * 输入
 * ["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"]
 * [[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
 * 输出
 * [null, null, null, true, false, true]
 *
 * 解释
 * RangeModule rangeModule = new RangeModule();
 * rangeModule.addRange(10, 20);
 * rangeModule.removeRange(14, 16);
 * rangeModule.queryRange(10, 14); 返回 true （区间 [10, 14) 中的每个数都正在被跟踪）
 * rangeModule.queryRange(13, 15); 返回 false（未跟踪区间 [13, 15) 中像 14, 14.03, 14.17 这样的数字）
 * rangeModule.queryRange(16, 17); 返回 true （尽管执行了删除操作，区间 [16, 17) 中的数字 16 仍然会被跟踪）
 *
 *
 * 提示：
 *
 * 1 <= left < right <= 109
 * 在单个测试用例中，对 addRange 、  queryRange 和 removeRange 的调用总数不超过 104 次
 *
 * link: https://leetcode.cn/problems/range-module/
 */
public class Problem715 {
    /**
     * Your RangeModule object will be instantiated and called as such:
     * RangeModule obj = new RangeModule();
     * obj.addRange(left,right);
     * boolean param_2 = obj.queryRange(left,right);
     * obj.removeRange(left,right);
     */
    static class RangeModule {
        static class Node {
            Node l, r;
            int val, add;
        }
        Node root = new Node();
        int N = (int) 1e9 + 5;

        public RangeModule() {
            super();
        }

        private void push_up(Node p) {
            p.val = p.l.val + p.r.val;
        }

        private void push_down(Node p, int len) {
            if (p.l == null) p.l = new Node();
            if (p.r == null) p.r = new Node();
            if (p.add == 0) return;
            if (p.add == -1) {
                p.l.val = p.r.val = 0;
            } else {
                p.l.val = len - len / 2;
                p.r.val = len / 2;
            }
            p.l.add = p.r.add = p.add;
            p.add = 0;
        }

        public void update(int l, int r, int d, Node p, int lc, int rc) {
            if (l <= lc && rc <= r) {
                p.val = d == 1 ? rc - lc + 1 : 0;
                p.add = d;
                return;
            }
            push_down(p, rc - lc + 1);
            int mid = lc + rc >> 1;
            if (l <= mid) update(l, r, d, p.l, lc, mid);
            if (r > mid) update(l, r, d, p.r, mid + 1, rc);
            push_up(p);
        }

        public int query(int l, int r, Node p, int lc, int rc) {
            if (l <= lc && rc <= r) return p.val;
            push_down(p, rc - lc + 1);
            int mid = lc + rc >> 1, ans = 0;
            if (l <= mid) ans += query(l, r, p.l, lc, mid);
            if (r > mid) ans += query(l, r, p.r, mid + 1, rc);
            return ans;
        }

        public void addRange(int left, int right) {
            update(left, right - 1, 1, root, 1, N);
        }

        public boolean queryRange(int left, int right) {
            return query(left, right - 1, root, 1, N) == right - left;
        }

        public void removeRange(int left, int right) {
            update(left, right - 1, -1, root, 1, N);
        }
    }
}
