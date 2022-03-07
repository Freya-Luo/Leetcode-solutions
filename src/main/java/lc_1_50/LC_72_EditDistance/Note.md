### Thinking
**Solution - DP**
> Typical Levenshtein distance -- [ref](https://en.wikipedia.org/wiki/Levenshtein_distance)

- Logic: 
  - init `dp[i][0] and dp[0][j]` to be increasing numbers
    - meaning min steps required to form the substring `s1[0...i]` and `s2[0...j]`
  - for the rest of the `dp[][]` table
    - if `s[i] == s[j]`, nothing changes, the same result as `dp[i - 1][j - 1]`
    - else 3 operations can be made, choose the min one
      - op1: delete `i` in `s1`, which should has the result from `dp[i - 1][j] + 1`
      - op2: insert `j` in `s2`, which should has the result from `dp[i][j - 1] + 1`
      - op3: replacement one of `i` and `j`, which should has the result from `dp[i - 1][j - 1] + 1`