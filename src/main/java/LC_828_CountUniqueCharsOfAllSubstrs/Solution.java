package LC_828_CountUniqueCharsOfAllSubstrs;
import java.util.Arrays;

class Solution {
    /**
     * This function change the logic.
     * Instead of counting all the substrings and calculate each unique chars,
     * it counts the number of ways/substring combinations to make current char be unique
     * for every char in the string s.
     *
     * Time: O(n)
     * Space: O(n)
     */
    public int uniqueLetterString1(String s) {
        int[] lastIdx = new int[26];
        int[] secondToLastIdx = new int[26];
        int n = s.length(), res = 0;

        Arrays.fill(lastIdx, -1);
        Arrays.fill(secondToLastIdx, -1);

        for(int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'A';
            int numOfWaysToRight = i - lastIdx[idx];
            int numOfWaysToLeft = lastIdx[idx] - secondToLastIdx[idx];

            res += numOfWaysToLeft * numOfWaysToRight;

            secondToLastIdx[idx] = lastIdx[idx];
            lastIdx[idx] = i;
        }

        // Deal with all the single chars or duplicate chars at the first/last position of the string
        for(int c = 0; c < 26 ; c++) {
            int numToRightBySingleChar = n - lastIdx[c];
            int numToLeftBySingleChar = lastIdx[c] - secondToLastIdx[c];
            res += numToRightBySingleChar * numToLeftBySingleChar;
        }
        return res;
    }

    /**
     * Key line #62: sum s[k:i] = sum s[k:i-1] + # of substrings (c that appears 0 time in s[k:i-1])
     * - # of substrings (c that appears 1 time in s[k:i-1])
     * => cur(s[k:i] new value) = cur(s[k: i-1] from last loop) + (i - lastIdx + 1) - (lastIdx - secToLastIdx + 1)
     *
     * Time: O(n)
     * Space: O(n)
     */
    public int uniqueLetterString2(String s) {
        int[] lastIdx = new int[26];
        int[] secondToLastIdx = new int[26];
        int n = s.length();

        int res = 0, cur = 0;

        Arrays.fill(lastIdx, -1);
        Arrays.fill(secondToLastIdx, -1);

        for(int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'A';
            int last = lastIdx[idx];
            int secToLast =  secondToLastIdx[idx];

            cur = cur + (i - last + 1) - (last - secToLast + 1);
            res += cur;

            secondToLastIdx[idx] = lastIdx[idx];
            lastIdx[idx] = i;
        }
        return res;
    }
}