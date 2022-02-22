### Thinking
**Solution - DP (LIS)**
- Logic:
  - One way to think of it
    - have LIS for different length:
      - for each `len`, pick the one with the smallest element as a promising candidate with `len`
      - when inserting a new `num`, if all `tails` is smaller than `num`, we can now expand the `len` by increasing 1
      - here, `dp[i - 1]` stores the smallest tail num if the LIS length is `i`
      ```markdown
      arr: [1,3,5,2,8,4,6]
      - len == 1: [1], [3], [5], [2], [8], [4], [6], so dp[0] = 1 ----------  [1, 0, 0, ...., 0]
      - len == 2: [1,2] [1,3] [3,5] [2,8], ...., pick [1, 2 (tail)] so dp[1] = 2 ------------[1, 2, 0, .....  0]
      - len == 3: pick [1, 3, 4], so dp[2] = 4 -------------- [1, 2, 4, 0, ....... 0]
      - len == 4: pick [1, 3, 5, 6], so dp[3] = 6 ----------------[1  2, 4, 6, 0, ........., 0]
      // if next comes another 3
      - found len 3 [1, 3, 4] whose tail num is just greater than 3, update it with [1, 3, 3] and dp[2] = 3 
      ```
  - specification
    - `len`: length of the current LIS, 
      - if `dp[i - 1]` is filled with some number, then it means length of `i` LIS has been detected
    - `if (right/left == len) len++;`
      - the BS range should be `[left, right/len)`, so if the search outcome (the correct place to put the `curNum`) is at `len`:
        - it implies that all numbers before index `len` are smaller than `curNum`
        - so, put `curNum` at the boundary `right/len`, the length is increased by 1
    - WHY BS ?
      - reduce time complexity to `O(nlogn)` as we need to replace the 1st element (among all tails) that is `>= curNum` with `curNum`
        - gives more opportunity for numbers that are `>= curNum` but `< replacedNum` to be included in the 
- Note
  - `dp[]` is not always a valid subsequence , but its length is correct
    - e.g. `[3, 4, 5, 1]` and `dp` will be `[1, 4, 5]` at the end - `1 replace 3 in dp[]`
    - length remains correct cuz `len` is only changed when a new num is larger than any tails in the subsequence
      - THEN, it is appended to the IS, not replacing an existing element