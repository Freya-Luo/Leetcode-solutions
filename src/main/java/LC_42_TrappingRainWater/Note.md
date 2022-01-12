### Thinking
**Solution - Monotonic Stack**
- Key: height increasing order - using `i` to conveniently get both `width` and `height[i]`
  - remove `i` if current height `>` height at the top of the stack
    - water collected is bounded by the `height[i]` & `height[stack.top()]`
    - get`(peek())` top height; then using `min` of them -> get water to `ans`
  - else add `i` to the stack
    - water collected is bounded by the heights in stack
##### Note
- 1st `pop()` would be the bottom height
- 2nd `top()` of the stack would be another side of the container
  - So, `width = i - stack.peek() - 1;`
  - in next loop, this would be the bottom height `(as we can treat "filled water area" as wall now)`

**Solution - DP (Two way pass)**
- `left[i]` -- records the **max** num from `0 -> i`
- `right[i]` -- records the **max** num from `(n - 1) -> i`
- for each position `i`
  - get the `min` height of them; then `minOne - height[i]` => amount of water needed to fill this bar