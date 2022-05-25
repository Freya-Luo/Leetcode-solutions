package lc_651_700.LC_670_MaximumSwap;

/**
 * Ex: 67777723; Searching backwards, in which way we can make sure
 * the current max number would be the max number in the substring[i, n].
 */
class Solution_Backward {
    // Time: O(n)
    public int maximumSwap(int num) {
        int[] digits = Integer.toString(num).chars().map(c -> c-'0').toArray();
        int n = digits.length;

        int maxIdx = n - 1, sm = 0, lg = 0;
        for(int i = n - 1; i >= 0; i--) {
            // update the max number index in the substring [i, ... n-1]
            if (digits[i] > digits[maxIdx]) {
                maxIdx = i;
            } // sm: the most front number that is smaller than the max in s(i, n]; lg: max in s(i, n]
            else if (digits[i] < digits[maxIdx]) {
                sm = i;
                lg = maxIdx; // make sure that the max number we want to swap is behind the small number
            }
        }

        int temp = digits[lg];
        digits[lg] = digits[sm];
        digits[sm] = temp;

        StringBuilder sb = new StringBuilder();
        for(int d: digits) {
            sb.append(d);
        }
        return Integer.parseInt(sb.toString());
    }
}
