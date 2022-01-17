### Thinking
**Solution 1 - Deque**
- Key: keep a `[] deque`, where **1st** index corresponding to the `max` in the current window
  - How? -- for each `num` in array
    - remove `front elements` to keep `window` be the size `k`
    - remove `rear elements` that are smaller then current `nums[i]`
    - set the `max` num for the `current window (i - k + 1)`
    - So, there could be 4 cases:
      - case 1: for the 1st `k` nums (initially), **only** `max` num index is left in the `deque`
      - case 2: when new `nums[i]` is the <u>smallest</u>, just **add** the `index` to the `deque`
      - case 3: when new `nums[i]` is in the <u>middle zone</u>, **remove all** the `rear eles` **smaller** than `nums[i]`; then add `i`
        - as they won't be the answer anymore
      - case 4: when new `nums[i]` is the <u>largest</u>, remove all `indices` in `deque`; then add `i`
- Principle: `idx[0, i - 1], idx[i]` always keep the following properties:
  - p1: `nums[idx[0]]` always be the `max` in the cur window
  - p2: `idx[]` <=> the num in `nums[]` dynamically keeps the **descending order**
    - `nums[idx[0]]` be A, `nums[idx[idx.length - 1]]` be B, then `nums[idx[1]... idx[idx.length - 1]]` will maintain `A >= any >= B`
  > Generally, remove `front` to keep size & remove `rear` to keep descending order
- Trick: using `index` instead of `num` in `deque`
  - as we both need `i` & `nums[i]` info

**Solution 2 - Bidirectional serach Max**
- Idea: A window `[a, b, c, d, e]` can be divided into `[left, right]` parts
  - ex: `[a, b] [c, d, e]` - left max kept in `b's pos`; right max kept in `c's pos`
  - left dir: `nums[i]` -- beginning of the block ->  index `i`
  - right dir: `nums[i]` -- end of the block ->  index `i`
  - `res[i]` will be `Math.max(right[i], left[i + k - 1])`
