package lc_1001_1050.LC_1048_LongestStringChain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    // DP - Time: O(n * w^2): n: words.length, w: word.length()
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> map = new HashMap<>();

        int maxLen = 0;
        for(String word : words) {
            int max = 1;
            for(int i = 0; i < word.length(); i++) {
                String pre = word.substring(0, i) + word.substring(i + 1);

                if (map.containsKey(pre)) {
                    max = Math.max(max, map.get(pre) + 1);
                }
            }
            map.put(word, max);
            maxLen = Math.max(maxLen, max);
        }
        return maxLen;
    }
}
