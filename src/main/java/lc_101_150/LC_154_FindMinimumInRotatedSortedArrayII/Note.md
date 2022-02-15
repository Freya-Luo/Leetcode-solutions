### Thinking
Instead of fussing around `while` loop condition and `left & right` moves to avoid the inifinite loop, I find this initialization template for solving binary search hels me a lot.
- set **`left = -1, rigth = nums.length`**, enclosing the array.
- `while` loop condition can **always be `left + 1< right`**
- Then, inside loop, when certain conditions are met, moving **`left = mid / right = mid`**
##### Note
Above template works fine for most of the BS questions, but it still depends on the specific case. Typically, we should consider:
- the subarray should be totally <u>enclosed</u> by 2 pointers, a.k.a `left, [sub[p] , sub[p +1], ...,  sub[q]], right`
- after narrowing down, subarray should <u>not rule out the promising elements</u>
 ---
**Differences vs LC 153:**
1) Because of the duplicates **LC 154**, we need to extra `nums[mid] == nums[right - 1]`  this case from the `else` in Q.153. Now,  `right` pointer needs to move to narrow down the subarray as we have no information about left-side subarray. And we can only move 1 step further as the `min` number may exist between `[mid, right]`.
2) Consider when we finally move to the break point:
```
arr:   A         2      0          B
i:  (left)p-1    p      q     (right)q+1
w/o duplicates:        left
with duplicates:       right
```
- w/o duplicates **153**, we have a merged case `nums[mid] >= nums[right - 1`,  where `left` is moved to `mid`
    - follow the logic above, `left` finally points to `arr[q] = 0` => so `nums[left]` is returned
- with duplicates **154**, case `nums[mid] == nums[right - 1` moves `right` 1 position forward
    - finally, `right` points `arr[q] = 0` => so `nums[right]` is returned