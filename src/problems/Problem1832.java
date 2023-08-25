package problems;

public class Problem1832 {
    public static void main(String[] args) {

    }

    public boolean checkIfPangram(String sentence) {
        int[] hash = new int[26];
        int cnt = 0;
        for (char c : sentence.toCharArray()) {
            if (++hash[c - 'a'] == 1) cnt++;
        }
        return cnt == 26;
    }
}
