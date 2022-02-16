package lc_751_800.LC_746_MinCostClimbingStairs;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int oneStepPrev = 0, twoStepsPrev = 0;
        int cur = 0;
        for(int i = 2; i <= n; i++) {
            // either go from 1 step previous & take that cost
            // or go from 2 steps previous & take that cost

            // NOTE: when you go away from this cell, you take the cost;
            // so the cost taken at this position should be value at the `from` position
            cur = Math.min(oneStepPrev + cost[i - 1], twoStepsPrev + cost[i - 2]);
            twoStepsPrev = oneStepPrev;
            oneStepPrev = cur;
        }

        return cur;
    }
}
