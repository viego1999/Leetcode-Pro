package problems;

import java.util.TreeSet;

public class Problem855 {
    public static void main(String[] args) {

    }

    static class ExamRoom {
        TreeSet<Integer> set = new TreeSet<>();
        int n;

        public ExamRoom(int n) {
            this.n = n;
        }

        public int seat() {
            int idx = 0;
            if (set.size() > 0) {
                Integer last = null, dis = set.first(); // 在第0位时
                for (Integer curr : set) {
                    if (last != null) {
                        int d = (curr - last) / 2;
                        if (d > dis) idx = last + (dis = d);
                    }
                    last = curr;
                }
                int d = n - 1 - last; // 在最后一位时
                if (d > dis) idx = n - 1;
            }
            set.add(idx);
            return idx;
        }

        public void leave(int p) {
            set.remove(p);
        }
    }
}
