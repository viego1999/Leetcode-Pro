package problems;

import java.util.ArrayList;
import java.util.List;

public class Problem1408 {
    public static void main(String[] args) {

    }

    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (j != i && words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
}
