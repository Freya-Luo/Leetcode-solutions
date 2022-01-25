### Thinking
**Solution - BS**
- Key: `nums[mid]` should compare with `nums[right]` 
  - larger sub-array is always on the left while smaller sub-array is always on the right
  - SO, `smallest` must be in the 2nd sub-array
    - which is kind of like `Find 1st bad version`
- Logic: 
  - conditional statement narrows down the boundary of 2nd smaller sub-array
  - if `nums[mid] < nums[high]`
    - move right to `mid`, but `nums[mid]` is still promising -> x rule out
  - else 
    - move left to `mid + 1` as `nums[mid]` cannot be the answer
- HOW to decide what to return?
  - before exit out of `while` loop
  - Ex: `(2 0) with index [p, q]`
    - we set `left & right` to be the guardian pos outside `nums`
    - `left = p - 1, right = q + 1` => `mid = p;` => `1st if fails, as 2 < 0` => `left = p`
    - in next loop, `left -> p`