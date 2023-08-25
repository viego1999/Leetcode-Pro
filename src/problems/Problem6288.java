package problems;

public class Problem6288 {

    /**
     * Your DataStream object will be instantiated and called as such:
     * DataStream obj = new DataStream(value, k);
     * boolean param_1 = obj.consec(num);
     */
    static class DataStream {

        private int value, k, count = 0;

        public DataStream(int value, int k) {
            this.value = value;
            this.k = k;
        }

        public boolean consec(int num) {
            if (num == value) count++;
            else count = 0;
            return count >= k;
        }
    }
}
