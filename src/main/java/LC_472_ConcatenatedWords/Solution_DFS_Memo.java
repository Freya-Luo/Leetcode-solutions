package LC_472_ConcatenatedWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution_DFS_Memo {
    private boolean DFSWalk(String word, HashSet<String> preWords,
                            int start, Boolean[] checkedSubstr) {
        if(preWords.isEmpty()) return false;
        if(start == word.length()) return true;

        //Boolean Type default value is null
        if(checkedSubstr[start] != null) return checkedSubstr[start];

        for(int end = start + 1; end <= word.length(); end++) {
            if(preWords.contains(word.substring(start, end))
                    && DFSWalk(word, preWords, end, checkedSubstr)) {
                checkedSubstr[start] = true;
                return true;
            }
        }
        checkedSubstr[start] = false;
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        // O(nlogn)
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        HashSet<String> preWords = new HashSet<>();
        for(int i = 0; i < words.length; i++){
            if(DFSWalk(words[i], preWords, 0, new Boolean[words[i].length()])) {
                res.add(words[i]);
            }
            preWords.add(words[i]);
        }

        return res;
    }
}