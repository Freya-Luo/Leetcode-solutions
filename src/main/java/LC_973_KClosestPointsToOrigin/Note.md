### Thinking
**Solution - MaxPQ**
- WHY `MaxPQ` instead of `MinPQ`
  - as internal structure heap, we can only get the info about the **top** element
  - So, to keep size `k` of the `PQ`, need to compare the `max` value in it instead of `min`

**Solution - Quick Select**
- similar to `top k` question, reduce time from `O(NlogN) -> O(N)` on avg.
- `in-place` sort k entries in the array
  - no need to construct a `new int[][]` & fussy about chopping part of the array
    > what if `num == k` actually does not meet, the recursion terminates at `left >= right`? Cases are not, harder to think