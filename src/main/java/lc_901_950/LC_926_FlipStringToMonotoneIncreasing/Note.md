### Thinking
**Solution 1 - DP**
- if `s[i] == '1'`, do nothing because it keeps the monotone property as being the last char in `s[0:i]`
- if `s[i] == '0'`,
    - Either filpping it to `1`, then `count + 1`
    - Or count the `number of 1` in `s[0: i -1]`, which is the times of flipping needed to make `s` be all `0's`
        - keep a `var` to count the number of `1` in `s[0:i-1]`

**Solution 2 - Prefix Sum**
- partition the array into 2 parts (first part filled with `0's`, second with all `1's`)
  - `[0 ... i][i+1 .... n]`: 
     - `sum[i]` => num of `1` in the left part of `s`
     - `sum[n] - sum[i]` => num of `1` in the right part of `s`
       - **`(n - i) - (sum[n] - sum[i])`** => num of `0` in the right part
  - goal: flip all `1's` in the left and flip all `0's` in the right part
    - get the **min** flipping actions required
  ###### Note
  - need `sum[n + 1]`: 1st ele as the guardian in the case of
    - `111011` where the correct ans is to put `|` boundary in front of the `s`
      - split as: ` |111011`
      - SO, loop from `i = 0`, X `i = 1`
  