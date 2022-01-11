### Thinking
###### Compare
- vs LC`239`
    - Basically, same idea when keeping the **monotonous** property of the `stack/queue`
        - this one -> mono increasing order
        - `239` -> mono decreasing order
    - But, why not using `i` in stack `(e.g., rightCnt - i)`?
        - because the no.of prev left/right numbers that get `pop()` is needed
        - still need a 2nd entry to record this count - once pop out, `i` info will be lost

**Solution - Monotonic Stack**
- Key: `res[i] = sum(arr[i], F(i))`
  - `F(i)` counts the **number of substrs** where <u>`arr[i]` is the min number</u>
  - HOW to calculate?
    - `leftCnt[i]` - length (include `arr[i]`) of subarray(contiguous) to the left of `arr[i]` where each ele is larger than it
    - `rightCnt[i]` - length (include `arr[i]`) of subarray(contiguous) to the right of `arr[i]` where each ele is larger than it
    - then, `F(i) = leftCnt[i] * rightCnt[i] `
      - Ex: `[3 1 2 4]`, `arr[i]` be 1
        - `leftCnt[i]` be 2
        - `rightCnt[i]` be 3
        - so, 6 substrs `31, 312, 3123, 12, 124, 1` take `1` as the min number
###### Note
- Type conversion `(long)` > `*` **higher** precedence
  - avoid overflow, 1st do `(long) arr[i]`
- 2nd for loop - a.k.a `largerAtRight` stack not put in the same loop
  - <i>memory access pattern and cache behaviors</i> taken into consideration
- <u>One and only one</u> of the comparison between `arr[i] & stack.peek()[0]` should include the duplicates
  - either `arr[i] <= largerAtLeft.peek()[0]` or` arr[i] <= largerAtRight.peek()[0]` includes `=`