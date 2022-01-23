### Thinking
**Solution - DFS**
- Key: find the `min` => Greedy, also move the coin from the closest available node
  - bottom-up post-order would be the solution
- Logic:
  - for each node, we get excess/insufficient coins from its `left & right` children & move them
    - `balance(root) = root.val + left + right - 1`
    - if `root.val == 0`, then would be `-1`
  - then, the moves would be `leftMoves + rightMoves`, which are equals to quantitative value of excess coins
    - `moves += Math.abs(balance(root.left)) + Math.abs(balance(root.right))`
- [Visualization](https://leetcode.com/problems/distribute-coins-in-binary-tree/discuss/221939/C%2B%2B-with-picture-post-order-traversal)