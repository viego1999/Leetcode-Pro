package problems;

public class Problem1812 {
    public static void main(String[] args) {

    }

    public boolean squareIsWhite(String coordinates) {
        return ((coordinates.charAt(0) - 'a') & 1) == ((coordinates.charAt(1) - '0') & 1);
    }
}
