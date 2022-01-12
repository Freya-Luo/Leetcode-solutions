package LC_127_WordLadder;

import java.util.*;

class Solution_Bidir_BFS {
    /**
     * Typical 2-way BFS: Time: O(M^2 * N), but searching time would be half
     * Space: O(N)
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<>(wordList);

        if(!wordDict.contains(endWord)) return 0;

        Deque<String> srcDq = new ArrayDeque<>(), desDq = new ArrayDeque<>();
        srcDq.offer(beginWord);
        desDq.offer(endWord);

        Set<String> srcVisited = new HashSet<>(), desVisited = new HashSet<>();
        srcVisited.add(beginWord);
        desVisited.add(endWord);

        int srcLevel = 1, desLevel = 1;
        while(!srcDq.isEmpty() && !desDq.isEmpty()) {  //O(N)
            // Searching from src
            int srcSize = srcDq.size();
            while (srcSize > 0) {
                char[] curWord = srcDq.poll().toCharArray();

                for(int i = 0; i < curWord.length; i++) {
                    char oriChar = curWord[i];
                    for(char c = 'a'; c <= 'z'; c++) { //O(1)
                        curWord[i] = c;

                        String nextWord = String.valueOf(curWord);  // O(M)

                        if (desVisited.contains(nextWord)) return srcLevel + desLevel;

                        if (wordDict.contains(nextWord) && !srcVisited.contains(nextWord)) {  //O(1)
                            srcDq.offer(nextWord);
                            srcVisited.add(nextWord);
                        }
                    }
                    curWord[i] = oriChar;
                }
                srcSize--;
            }
            srcLevel++;
            // Searching from des
            int desSize = desDq.size();
            while (desSize > 0) {
                char[] curWord = desDq.poll().toCharArray();

                for(int i = 0; i < curWord.length; i++) {
                    char oriChar = curWord[i];
                    for(char c = 'a'; c <= 'z'; c++) { //O(1)
                        curWord[i] = c;

                        String nextWord = String.valueOf(curWord);  // O(M)

                        if (srcVisited.contains(nextWord)) return srcLevel + desLevel;

                        if (wordDict.contains(nextWord) && !desVisited.contains(nextWord)) {  //O(1)
                            desDq.offer(nextWord);
                            desVisited.add(nextWord);
                        }
                    }
                    curWord[i] = oriChar;
                }
                desSize--;
            }
            desLevel++;
        }
        return 0;
    }
}
