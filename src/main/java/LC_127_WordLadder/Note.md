### Thinking
**Solution -BFS**
- Note!
  - keep the original char `oriChar` when doing the transformation
    - NEED to **reverse back** for the next loop (change 1 char at a time)

**Solution - Bidirectional BFS**
 - Typically, if branching factor is `b` and distance is `d`
   - BFS - O(b<sup>d</sup>); but bidir BFS - O(2b<sup>d/2</sup>)
 - **Improved Version** -- [reference](https://leetcode.com/problems/word-ladder/discuss/40708/Share-my-two-end-BFS-in-C%2B%2B-80ms.)
   - Not following the order in `src-des-src-des`
   - Performance improved by:
     - always add the new string into the smaller `set/deque` - balance 2 sets size
   