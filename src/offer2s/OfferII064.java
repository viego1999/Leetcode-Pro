package offer2s;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII064
 * @since 2023/5/14 0:07
 */
public class OfferII064 {
    public static void main(String[] args) {

    }

    /**
     * Your MagicDictionary object will be instantiated and called as such:
     * MagicDictionary obj = new MagicDictionary();
     * obj.buildDict(dictionary);
     * boolean param_2 = obj.search(searchWord);
     */
    static class MagicDictionary {
        private String[] dictionary;

        /** Initialize your data structure here. */
        public MagicDictionary() {

        }

        public void buildDict(String[] dictionary) {
            this.dictionary = dictionary;
        }

        public boolean search(String searchWord) {
            for (String word : dictionary) {
                if (word.length() != searchWord.length()) continue;
                int diff = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) != searchWord.charAt(i)) {
                        if (++diff > 1) break;
                    }
                }
                if (diff == 1) return true;
            }
            return false;
        }
    }
}
