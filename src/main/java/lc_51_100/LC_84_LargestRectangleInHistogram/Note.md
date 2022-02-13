### Thinking
**Solution - DP**
- Logic:
  - `firstSmallerFromCurToLeft[]` & `firstSmallerFromCurToRight[]` records the 1st bar smaller than the current height 
    - if we start searching _from current bar to the left and right_
    - image two pointers `left` & `right`, the current bar is at index `i`
      - `left`: _first index of the bar to the **left**_ where `heights[left] < heights[i]`
      - `right`: _first index of the bar to the **right**_ where `heights[right] < heights[i]`
      - then, the `width` would be `right - letf - 1` & `height` would be `heights[i]` as the bottom line
- _Tricky Point_
  - when looking for the index, `left = firstSmallerFromCurToLeft[left]` really does the magic
    - reduce time complexity from O(n^2) to O(n)
  - HOW?
    - if `heights[left] >= heights[i]`, since `left < i`, which means the search for `left` has been already been finished
    - that is, the effort to _find the nearest smaller number to the left_ of `heights[left]` **has been done**
    - SO, all numbers between index `firstSmallerFromCurToLeft[left] ~ left` are greater than `heights[left]`, we do not need to traverse it again
    - THUS, just jump to that index and start searching from there - `firstSmallerFromCurToLeft[left]`

**Solution - Mono Stack**  
- [ref](https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/452612/Thinking-Process-for-Stack-Solution)
- Logic:
  - put "promising" candidates into the `stack`, pushing `index` instead of `number` as we need both information
  - what is PROMISING?
    - when we find the increasing order, the higher bar gives the hope of finding larger rectangles
    - but, if we find a bar lower than the vat at the `top` of the `stack`
      - this bar `i` _constraints the future rectangle's height_
      - which also means the _previous higher bar cannot be extended_ anymore
      - SO, we pop all the bars that are higher than the current bar `i`, and calculate the area
        - NOTE, we should stop when the `top` bar is lower than the current bar `i`
        - as that bar also gives a hope by forming a wider `width`
  - finally, we calculate the increasing bar order in `stack` 
    - the widths are all `n - i - 1`