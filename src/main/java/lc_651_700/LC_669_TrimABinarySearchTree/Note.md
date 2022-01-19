### Thinking
**Solution -Recursion**
- WHY post-order?
  - need 1st to recursively find the node falling in the `[low, high]` & then do operations
- Logic:
  - if `cur.val < low`, drop `cur.left` => return trimmed `cur.right`
  - if `cur.val > high`, drop `cur.right` => return trimmed `cur.left`
  - if `cur.val ~ [low, high]`
    - recursively check `cur.left` to try to expend `left` boundary
    - also, check `cur.right` to try to expend `right` boundary

**Solution-Iteration**
- Logic: 
  - 1st, find the starting node `root` that correctly falls into the range `[low, high]`
  - then, for both sides
    - while `cur.val` is out of the range
      - narrow down its range in the next level `cur.left = cur.left.right` (try larger one) or `cur.right = cur.right.left` (try smaller one)
    - once find a proper node, relink them