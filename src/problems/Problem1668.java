package problems;

public class Problem1668 {
    public static void main(String[] args) {
        System.out.println(maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }

    public static int maxRepeating(String sequence, String word) {
        int ans = 0;
        StringBuilder sb = new StringBuilder(word);
        while (sequence.contains(sb)) {
            ans++;
            sb.append(word);
        }
        return ans;
    }
}
