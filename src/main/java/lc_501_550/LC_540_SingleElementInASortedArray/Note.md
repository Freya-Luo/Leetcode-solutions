### Thinking
**Solution-BS**
- Key: Keep the SubRange structure aligns with the initially defined ArrayRange
  - `lengh` is odd => must have that singlet
  - init, `left & right` are outside the `nums` as the guardians
  - So, when narrowing down the sub-array & shifting the `left, right` pointers
    - keep them outside the sub-array
    - Never narrow out the promising result entry `nums[mid]` unless we ensure it will not be the answer
      > In this question, when we find `nums[mid]` has replica, we are sure that this cannot be the ans;  
      > Also, to keep the pointers as the guardian of sub-array, we must do `left = mid + 1` & `right = mid - 1`