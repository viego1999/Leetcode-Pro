package offer2s;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName OfferII109
 * @since 2023/5/26 15:20
 */
public class OfferII109 {
    public static void main(String[] args) {

    }

    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends)), used = new HashSet<>();
        if (deads.contains("0000") || deads.contains(target) || target.equals("0000")) return target.equals("0000") ? 0 : -1;
        Set<String> starts = new HashSet<>(), ends = new HashSet<>();
        int ans = 1;
        starts.add("0000");
        ends.add(target);
        while (!starts.isEmpty() && !ends.isEmpty()) {
            if (starts.size() > ends.size()) {
                Set<String> temp = starts;
                starts = ends;
                ends = temp;
            }
            Set<String> nexts = new HashSet<>();
            for (String str : starts) {
                char[] cs = str.toCharArray();
                for (int i = 0; i < cs.length; i++) {
                    int oc = cs[i] - '0';
                    cs[i] = (char) (((oc + 1) % 10) + '0');
                    String next = new String(cs);
                    if (!deads.contains(next)) {
                        if (ends.contains(next)) return ans;
                        if (!used.contains(next)) {
                            nexts.add(next);
                            used.add(next);
                        }
                    }
                    cs[i] = (char) (((oc + 9) % 10) + '0');
                    next = new String(cs);
                    if (!deads.contains(next)) {
                        if (ends.contains(next)) return ans;
                        if (!used.contains(next)) {
                            nexts.add(next);
                            used.add(next);
                        }
                    }
                    cs[i] = (char) (oc + '0');
                }
            }
            starts = nexts;
            ans++;
        }
        return -1;
    }
}
