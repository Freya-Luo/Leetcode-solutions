package lc_301_350.LC_339_NestedListWeightSum;

import java.util.List;

interface NestedInteger {
    boolean isInteger();

    Integer getInteger();

    List<NestedInteger> getList();
}
      // Constructor initializes an empty nested list.
 /*     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *    public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *    public Integer getInteger();
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
// Time: O(n) n: total number of nested layers & integers
class Solution {
    private int dfs(List<NestedInteger> nestedList, int depth) {
        int res = 0;
        for(NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                res += (ni.getInteger() * depth);
            } else {
                res += dfs(ni.getList(), depth + 1);
            }
        }
        return res;
    }

    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }
}