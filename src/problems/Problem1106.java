package problems;

public class Problem1106 {
    public static void main(String[] args) {

    }

    public boolean parseBoolExpr(String expression) {
        int n = expression.length(), t1 = 0, t2 = 0;
        char[] s1 = new char[n], s2 = new char[n];
        for (char v : expression.toCharArray()) {
            if (v == '!' || v == '|' || v == '&') s1[++t1] = v;
            else if (v == 'f' || v == 't' || v == '(') s2[++t2] = v;
            else if (v == ')') {
                char c = s1[t1--];
                boolean f = c != '|';
                while (s2[t2] != '(') {
                    boolean t = s2[t2--] == 't';
                    f = c == '!' ? !t : c == '&' ? f & t : f | t;
                }
                s2[t2] = f ? 't' : 'f';
            }
        }
        return s2[t2] == 't';
    }
}
