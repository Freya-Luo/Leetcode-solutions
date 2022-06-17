package lc_751_800.LC_780_ReachingPoints;

/**
 * Walk backwards. Convert the problem from "src to des" to "des" to "src".
 * So the possible directions are either left or down.
 * => This is like going from root to leaves, you have many options, however, going from leaf to
 * root, there is only one way up.
 *
 * E.g. 1. tx > ty. The next operations can only be to (tx - ty), until such time that tx = tx % ty.
 *      => 1.1 if also ty <= sy, then we know ty cannot change any more (it can only decrease).
 *      Thus, only tx can change, and it can only change by tx - ty.
 *      Hence, (tx - sx) % ty == 0 is a necessary and sufficient condition for checking the answer to be True.
 */
public class Solution {
    // (x, y) => (x, y-x) / (x-y, y)
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) { // (tx, ty) must be in the right-up area to the (sx, sy)
            if (tx > ty) {
                if (ty <= sy) return (tx - sx) % ty == 0;
                else tx %= ty;
            } else if(tx < ty) {
                if (tx <= sx) return (ty - sy) % tx == 0;
                else ty %= tx;
            } else return tx == sx && ty == sy;
        }
        return false;
    }
}