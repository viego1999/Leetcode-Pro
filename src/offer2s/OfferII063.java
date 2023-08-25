package offer2s;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII063
 * @since 2023/5/11 15:17
 */
public class OfferII063 {
    public static void main(String[] args) {

    }

    public String replaceWords(List<String> dictionary, String sentence) {
        List<String> ans = new ArrayList<>();
        dictionary.sort(String::compareTo);
        for (String word : sentence.split(" ")) {
            boolean flag = false;
            for (String d : dictionary) {
                if (word.startsWith(d)) {
                    ans.add(d);
                    flag = true;
                    break;
                }
            }
            if (!flag) ans.add(word);
        }
        return String.join(" ", ans);
    }
}
