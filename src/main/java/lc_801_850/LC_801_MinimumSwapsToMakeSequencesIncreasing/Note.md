### Thinking
**Solution**
- Logic: 
  - maintain two states for each pair of position - `swap[] & noswap[]`
    - `swap[i]`: min swaps needed to keep `nums[0: i]` increasing in the case `A[i]` and `B[i]` is swapped
    - `noswap[i]` min swaps needed to keep `nums[0 : i]` increasing if not perform swaps at `A[i]` and `B[i]`
  - base case: `swap[0] = 1` as `A[0]` and `B[0]` swaps following the logic
  - 2 cases involved: (since the answer is guaranteed to exist, so there are only 2 plausible cases)
    - case 1: `A[i - 1] < A[i] && B[i - 1] < B[i]`: operation (swap/not swap) should be the **same** on `i-1` and `i` pairs
      - `swap[i]` would be `swap[i -1] + 1` as `i - 1` swap, then `i` must swap to keep the order
      - `noswap[i]` would be `noswap[i - 1]` as both do not swap
    - case 2: `A[i - 1] < B[i] && B[i - 1] < A[i]`: operation (swap/not swap) should be the **opposite** on `i-1` and `i` pairs
      - implicit limitation if the answer must exist: `after 1 swap, both have to in the correct order`
      - `swap[i]` would be from `min(swap[i], noswap[i - 1] + 1)` as `i - 1` not swap, then `i` must swap 
      - `noswap[i]` would be from `min(noswap[i], swap[i - 1])` as `i - 1` swap, `i` do nothing
  - NOTE:
    - the relation is not `if/else`, they are parallel and must follow
      - **1st check case 1 and then check case 2**
        > WHY? As case 2 can include the condition in case 1, we have to compare with the case 1 and keep the optimal state/res. This is also why `min` comparison is used in case 2