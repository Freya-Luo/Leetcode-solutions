package LC_828_CountUniqueCharsOfAllSubstrs;
import java.util.Arrays;

class Solution {
    /**
     * This function change the logic.
     * Instead of counting all the substrings and calculate each unique chars,
     * it counts the number of ways/substring combinations to make current char be unique
     * for every char in the string s.
     */
    public int uniqueLetterString1(String s) {
        int[] lastIdx = new int[26];
        int[] secondToLastIdx = new int[26];
        int n = s.length(), res = 0;

        Arrays.fill(lastIdx, -1);
        Arrays.fill(secondToLastIdx, -1);

        for(int i = 0; i < n; i++) {
            int numOfWaysToRight = i - lastIdx[s.charAt(i) - 'A'];
            int numOfWaysToLeft = lastIdx[s.charAt(i) - 'A'] - secondToLastIdx[s.charAt(i) - 'A'];

            res += numOfWaysToLeft * numOfWaysToRight;

            secondToLastIdx[s.charAt(i) - 'A'] = lastIdx[s.charAt(i) - 'A'];
            lastIdx[s.charAt(i) - 'A'] = i;
        }

        // Deal with all the single chars or duplicate chars at the first/last position of the string
        for(int c = 0; c < 26 ; c++) {
            int numToRightBySingleChar = n - lastIdx[c];
            int numToLeftBySingleChar = lastIdx[c] - secondToLastIdx[c];
            res += numToRightBySingleChar * numToLeftBySingleChar;
        }
        return res;
    }
}