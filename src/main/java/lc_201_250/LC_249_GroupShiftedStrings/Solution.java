package lc_201_250.LC_249_GroupShiftedStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private String genHash(String s) {
        char[] chars = s.toCharArray();

        char offset = chars[0];
        for(int i = 0; i < chars.length; i++) {
            chars[i] = (char) ((chars[i] - offset + 26) % 26 + 'a');
        }
        return String.valueOf(chars);
    }
    // Time: O(N * M): N: strings.length; M: avg str.length
    // Space: O(N)
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> hashMap = new HashMap<>();

        for(String s: strings) {
            String hash = genHash(s);
            if (!hashMap.containsKey(hash)) {
                hashMap.put(hash, new ArrayList<>());
            }
            hashMap.get(hash).add(s);
        }

        List<List<String>> res = new ArrayList<>();
        for(List<String> list: hashMap.values()) {
            res.add(list);
        }
        return res;
    }
}