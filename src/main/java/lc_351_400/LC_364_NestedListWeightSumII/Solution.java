package lc_351_400.LC_364_NestedListWeightSumII;


import java.util.List;

// This is the interface that allows for creating nested lists.
 // You should not implement it, or speculate about its implementation
  interface NestedInteger {

     boolean isInteger();
     Integer getInteger();
     List<NestedInteger> getList();
 }
 /*     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
// Math problem : sum(ni * (maxD - di + 1) => (max + 1) * sum(ni) - depthSum(ni * di) -- Lc 339
class Solution {
    private int maxDepth = 0;
    private int sum = 0;

    private int dfs(List<NestedInteger> nestedList, int depth) {
        int res = 0;
        maxDepth = Math.max(maxDepth, depth);

        for(NestedInteger ni: nestedList) {
            if (ni.isInteger()) {
                res += (ni.getInteger() * depth);
                sum += ni.getInteger();
            } else {
                res += dfs(ni.getList(), depth + 1);
            }
        }
        return res;
    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int depthSum = dfs(nestedList, 1);
        return (maxDepth + 1) * sum - depthSum;
    }
}