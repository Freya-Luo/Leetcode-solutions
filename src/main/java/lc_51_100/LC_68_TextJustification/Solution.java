package lc_51_100.LC_68_TextJustification;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private String justifyLine(String[] words, int s, int e, int W) {
        // case 1: only 1 word in a line, just pad enough right spaces
        if (s == e) {
            int spaces = W - words[s].length();
            return String.format("%" + (-W) + "s", words[s]);
        }

        StringBuilder sb = new StringBuilder();
        // case 2: last line, left-justified
        if (e == words.length - 1) {
            for(int i = s; i <= e; i++) {
                sb.append(words[i]).append(" ");
            }
            return String.format("%" + (-W) + "s", sb.toString().trim());
        }

        // case 3: spaces are divided evenly
        int totalLen = 0;
        for(int i = s; i <= e; i++) {
            totalLen += words[i].length();
        }

        int totalSpaces = W - totalLen, slots = e - s;

        String spaceUnit = " ".repeat(totalSpaces / slots);
        int extraSpaces = totalSpaces % slots;

        for(int i = s; i < e; i++) {
            sb.append(words[i]).append(spaceUnit);
            if (extraSpaces-- > 0) {
                sb.append(" ");
            }
        }
        sb.append(words[e]);

        return sb.toString();
    }

    // O(n)
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int cur = 0;

        while (cur < words.length) {
            // find the word of the right boundary
            int sum = words[cur].length();
            int end = cur + 1;
            while (end < words.length && (sum + words[end].length() + 1) <= maxWidth) {
                sum += (words[end].length() + 1);
                end += 1;
            }
            // justify the current line
            String justified = justifyLine(words, cur, end - 1, maxWidth);

            res.add(justified);
            cur = end;
        }
        return res;
    }
}