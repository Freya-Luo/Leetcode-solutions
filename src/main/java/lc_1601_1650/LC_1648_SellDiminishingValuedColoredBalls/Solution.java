package lc_1601_1650.LC_1648_SellDiminishingValuedColoredBalls;

import java.util.Arrays;
import java.util.Collections;

class Solution {
    /**
     * Time: O(nlogn), n: arr.length
     */
    public int maxProfit(int[] arr, int orders) {
        // [5 5 5 3 3 2 1], 5
        // 3 3 4 3 3 2 1
        Integer[] inventory = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(inventory, Collections.reverseOrder());
        /** Changing from descending order to the ascending order => decrease runtime
         *
         * Arrays.sort(inventory);
         */

        int mod = 1000000007;

        long total = 0;
        int curIdx = 0; /** int curIdx = inventory.length - 1; */
        while(orders > 0) {
            int max = inventory[curIdx];
            int nextIdx = curIdx + 1; /** int nextIdx = curIdx - 1; */

            // deal with the ball types with the same total number
            while(nextIdx < inventory.length && inventory[nextIdx] == max) {
                nextIdx++;
            }
            int secToMax = nextIdx < inventory.length ? inventory[nextIdx] : 0;
            int numOfBallTypes = nextIdx;
            /**
             * while(nextIdx >= 0 && inventory[nextIdx] == max) {
             *     nextIdx--;
             * }
             * int secToMax = nextIdx >= 0 ? inventory[nextIdx] : 0;
             * int numOfBallTypes = inventory.length - 1 -nextIdx;
             */

            int count = numOfBallTypes * (max - secToMax);
            if (count <= orders) {
                // Grab all the balls
                total += (long) (secToMax + 1 + max) * count / 2;
            } else {
                // 5 5 5 => 4 4 4 => 3 3 4 (need 5 orders)
                int numOfFullRowDeducted = orders / numOfBallTypes;
                int remainder = orders % numOfBallTypes;

                total += (long) (max - numOfFullRowDeducted + 1 + max)
                        * numOfFullRowDeducted * numOfBallTypes / 2;
                total += (long) (max - numOfFullRowDeducted) * remainder;
            }
            orders -= count;
            // Key: Do not alter the inventory[] array, but change the max and secToMax index
            // As we always deduct from the max balls and make them same as the secToMax balls
            curIdx = nextIdx;
        }

        return (int) (total % mod);
    }
}