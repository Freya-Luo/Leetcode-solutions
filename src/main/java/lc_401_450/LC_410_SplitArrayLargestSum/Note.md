### Thinking
**Solution - Binary Search**
- search range: `left` is the `max num` in the array while `right` is the `sum`
- greedy to narrow down the range
  - try to keep `mid = (left + right) / 2` is the largest one among all subs' sum
  - two cases:
    - case 1: if more than `m` sub-arrays can be divided
      - means `mid` is too small, still have left numbers to form extra sub-groups
      - SO, increase the left boundary => `left = mid + 1`
    - case 2: if not - either less (use up all before reaching to `m`) or equal to `m`
      - means `mid` has the potential to be lowed down => `right = mid - 1`
##### Note
  - why `left <= right` ? 
    - as we still need to check if `mid` is the final result when `left` meets `right`
  - Keep in mind that the right answer falls into the `case 2`
    - this is why `left` is returned