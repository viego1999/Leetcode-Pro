package problems;

public class Problem1374 {
    public static void main(String[] args) {

    }

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
//        if ((n & 1) == 1) sb.append("a".repeat(n)); // jdk11
//        else sb.append("a".repeat(n - 1)).append("b"); // jdk11
        return sb.toString();
    }
}
