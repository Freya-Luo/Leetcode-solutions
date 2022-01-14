### Thinking
**Solution - MaxPQ**
- WHY `MaxPQ` instead of `MinPQ`
  - as internal structure heap, we can only get the info about the **top** element
  - So, to keep size `k` of the `PQ`, need to compare the `max` value in it instead of `min`

**Solution - Quick Select**
- similar to `top k` question, reduce time from `O(NlogN) -> O(N)` on avg.