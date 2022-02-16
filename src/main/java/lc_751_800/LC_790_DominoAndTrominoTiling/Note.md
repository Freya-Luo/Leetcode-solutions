### Thinking
**Solution - Single Array DP**
- Logic:
  - the formula for `dp[n]` is `dp[n] = dp[n - 1] + dp[n - 2] + 2 * (dp[n - 3] + dp[n - 4] + .... + dp[0])`
    - the arrangements for the current `F(n)` cols would be the sun of:
      - `F(n-1)` cols (adding vertical Domino) + `F(n-2)` cols (adding 2 horizontal Domino)
      - starting from `F(n-3)` cols, added Trominos has 2 arrangements in 3 cols => `2 * F(n - 3)`
      - the same logic applies for all `F(n - 4) ...` down to `F(0)`
  - so, `dp[n - 1] = dp[n - 2] + dp[n - 3] + 2 * (dp[n - 4] + dp[n - 5] + .... + dp[0])`
  - by subtracting, `dp[n] - dp[n - 1] = dp[n - 1] + dp[n - 3]`
  - THUS, final formula is : `dp[i] = 2 * dp[i - 1] % mod + dp[i - 3]`
  
**Solution - Two Arrays DP**
[ref picture](https://leetcode.com/problems/domino-and-tromino-tiling/discuss/116612/Easy-to-understand-O(n)-solution-with-Drawing-Picture-Explanation!)
- Logic: 
  - `T2[]` ends with Domino (full filling) while `T3[]` ends with Tromino (partial filling)
  - `T2[i] = T2[i - 1] + T2[i - 2] + 2 * T3[i - 1]` & `T3[i] = T3[i - 1]+ T2[i - 2]`