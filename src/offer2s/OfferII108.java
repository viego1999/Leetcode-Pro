package offer2s;

import java.util.*;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII108
 * @since 2023/5/26 14:39
 */
public class OfferII108 {
    public static void main(String[] args) {

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int ans = 1;
        Set<String> words = new HashSet<>(wordList), visited = new HashSet<>();
        if (!words.contains(endWord)) return 0;
        words.remove(beginWord);
        Set<String> begins = new HashSet<>(), ends = new HashSet<>();
        begins.add(beginWord);
        ends.add(endWord);
        while (!begins.isEmpty() && !ends.isEmpty()) {
            // 从小的集合开始
            if (begins.size() > ends.size()) {
                Set<String> temp = begins;
                begins = ends;
                ends = temp;
            }
            Set<String> nexts = new HashSet<>();
            for (String str : begins) {
                for (String word : words) {
                    char[] cs1 = str.toCharArray(), cs2 = word.toCharArray();
                    int diff = 0;
                    for (int i = 0; i < cs1.length; i++) {
                        if (cs1[i] != cs2[i]) {
                            if (++diff > 1) break;
                        }
                    }
                    if (diff == 1) {
                        if (ends.contains(word)) return ans + 1;
                        if (visited.contains(word)) continue;
                        nexts.add(word);
                        visited.add(word);
                    }
                }
            }
            begins = nexts;
            ans++;
        }
        return 0;
    }

    public int ladderLengthBfs(String beginWord, String endWord, List<String> wordList) {
        int ans = 1;
        Queue<String> queue = new ArrayDeque<>();
        boolean[] used = new boolean[wordList.size()];
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                String curr = queue.poll();
                if (curr.equals(endWord)) return ans;
                for (int j = 0; j < wordList.size(); j++) {
                    if (used[j] || curr.equals(wordList.get(j))) continue;
                    int diff = 0;
                    char[] cs1 = curr.toCharArray(), cs2 = wordList.get(j).toCharArray();
                    for (int k = 0; k < cs1.length; k++) {
                        if (cs1[k] != cs2[k]) {
                            if (++diff > 1) break;
                        }
                    }
                    if (diff == 1) {
                        queue.offer(wordList.get(j));
                        used[j] = true;
                    }
                }
            }
            ans++;
        }
        return 0;
    }
}
