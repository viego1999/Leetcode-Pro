package problems;

public class Problem2299 {
    public static void main(String[] args) {

    }

    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) return false;
        boolean hasLower = false, hasUpper = false, hasNum = false, hasSpec = false;
        String special = "!@#$%^&*()-+";
        char last = '~';
        for (char c : password.toCharArray()) {
            if (last == (last = c)) return false;
            if (c >= 'a' && c <= 'z') hasLower = true;
            else if (c >= 'A' && c <= 'Z') hasUpper = true;
            else if (c >= '0' && c <= '9') hasNum = true;
            else if (special.indexOf(c) != -1) hasSpec = true;
        }
        return hasLower && hasUpper && hasNum && hasSpec;
    }
}
