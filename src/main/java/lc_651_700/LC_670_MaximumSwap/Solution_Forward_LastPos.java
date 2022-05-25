package lc_651_700.LC_670_MaximumSwap;

/**
 * Actually, it can be taken as the DP problem. For each substring [i, ..., n],
 * find the max number behind that is larger than the first digit of this substring.
 */
class Solution_Forward_LastPos {
    // Time: O(n)
    public int maximumSwap(int num) {
        int[] digits = Integer.toString(num).chars().map(c -> c-'0').toArray();
        int n = digits.length;
        // forward looping; record each digit's index of the last occurrence
        int[] lastPos = new int[10];
        for(int i = 0; i < n; i++) {
            lastPos[digits[i]] = i;
        }

        for(int i = 0; i < n; i++) {
            int maxNum = 9;
            // find the max number that is larger than the current number
            // and this number should be behind the current one
            while (maxNum > digits[i]) { // O(9)
                if (lastPos[maxNum] > i) {
                    int temp = digits[i];
                    digits[i] = digits[lastPos[maxNum]];
                    digits[lastPos[maxNum]] = temp;

                    StringBuilder sb = new StringBuilder();
                    for(int d: digits) {
                        sb.append(d);
                    }
                    return Integer.parseInt(sb.toString());
                }
                maxNum--;
            }
        }
        return num;
    }
}
