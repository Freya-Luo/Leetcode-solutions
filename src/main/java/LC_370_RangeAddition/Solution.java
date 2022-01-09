package LC_370_RangeAddition;

class Solution {
    /**
     * Prefix Sum -- using boundary addition & subtraction
     * Time: O(N + m) N: length; m: updates.length
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] range = new int[length];

        for(int[] each : updates) {
            int start = each[0];
            int end = each[1] + 1;

            range[start] += each[2];
            if (end < length) {
                range[end] += -each[2];
            }
        }

        for(int i = 1; i < length; i++) {
            range[i] += range[i - 1];
        }
        return range;
    }
}