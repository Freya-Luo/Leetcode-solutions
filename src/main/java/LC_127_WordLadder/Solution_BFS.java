package LC_127_WordLadder;

import java.util.*;

class Solution_BFS {
    /**
     * Time: O(M^2 * N) - M: curWord.length; N: wordList.size()
     * Space: O(N)
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);

        if(!wordDict.contains(endWord)) return 0;

        Deque<String> dq = new ArrayDeque<>();
        dq.offer(beginWord);

        int level = 1;
        while(!dq.isEmpty()) {  //O(N)
            int curSize = dq.size();

            while (curSize > 0) {
                char[] curWord = dq.poll().toCharArray();
                // O(M^2), M: curWord.length
                for(int i = 0; i < curWord.length; i++) {
                    char oriChar = curWord[i];
                    for(char c = 'a'; c <= 'z'; c++) { //O(1)
                        curWord[i] = c;

                        String nextWord = String.valueOf(curWord);  // O(M)

                        if (nextWord.equals(endWord)) return level + 1;

                        if (wordDict.contains(nextWord)) {  //O(1)
                            wordDict.remove(nextWord);
                            dq.offer(nextWord);
                        }
                    }
                    curWord[i] = oriChar;
                }
                curSize--;
            }
            level++;  // Notice: put "level" outside the level traversal loop
        }
        return 0;
    }
}