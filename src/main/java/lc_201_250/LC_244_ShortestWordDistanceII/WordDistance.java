package lc_201_250.LC_244_ShortestWordDistanceII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * [i1, i2, i3, i4] & [j1, j2, j3] => find the pair of indices (i, j) whose absolute difference is min
 * if both are in sorted order, can find this pair in linear time (2 pointers).
 */
class WordDistance {
    private HashMap<String, List<Integer>> map = new HashMap<>();

    // O(n)
    public WordDistance(String[] words) {
        for(int i = 0; i < words.length; i++) {
            String w = words[i];
            if (!map.containsKey(w)) {
                map.put(w, new ArrayList<>());
            }
            map.get(w).add(i);
        }
    }

    // O(max(K,L)), K, L: num of occurrences of the two words
    public int shortest(String word1, String word2) {
        List<Integer> pos1 = map.get(word1);
        List<Integer> pos2 = map.get(word2);

        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        while (i < pos1.size() && j < pos2.size()) {
            min = Math.min(min, Math.abs(pos1.get(i) - pos2.get(j)));
            if (pos1.get(i) < pos2.get(j)) { // hope that abs(pos1[i + 1] - pos2[j]) gives a lower distance
                i++;
            } else if (pos1.get(i) > pos2.get(j)) { // hope that abs(pos1[i] - pos2[j + 1]) gives a lower distance
                j++;
            } else return 0;
        }
        return min;
    }
}