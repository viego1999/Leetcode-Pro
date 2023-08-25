package problems;

public class Problem1678 {
    public static void main(String[] args) {

    }

    public String interpret(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }
}
