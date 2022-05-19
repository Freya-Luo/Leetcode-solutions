package lc_751_800.LC_791_CustomSortString;

import java.util.HashSet;
import java.util.Set;

class Solution {
    // Time: O(n), n: s.length(); bucket sorting
    public String customSortString(String order, String s) {
        char[] cmap = new char[26];
        Set<Character> specified = new HashSet<>();
        for(int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            cmap[i] = c;
            specified.add(c);
        }

        int[] count = new int[26];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            if (specified.contains(sc)) {
                count[sc - 'a'] += 1;
            } else {
                sb.append(sc);
            }
        }

        for(int i = 0; i < order.length(); i++) {
            int idx = (char) (cmap[i] - 'a');
            for(int cnt = 1; cnt <= count[idx]; cnt++) {
                sb.append(cmap[i]);
            }
        }
        return sb.toString();
    }
}