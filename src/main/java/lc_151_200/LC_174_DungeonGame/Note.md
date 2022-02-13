### Thinking
##### Note
- Both solutions are based on the fact that one has to go from **_`bottom-right` to `top-left`_**
- **WHY can't** we reverse the path?
  - in a nutshell, we do not have any predictions for future path
    - in `top-left` to `bottom-right` approach, the path that depends on the future demons detected is not available
  - specifically,
    - at current position, we have <u>two factors</u> will influence the future paths decision - **current min HP needed `curMinHp` & current collected positive HP `curRemain`**
    - SO, at this position, we **cannot decide** if to _minimize `curMinHp`_ or _take maximum `curRemain`_ for the possible high cost for the future demons
  - BUT, with the reverse path searching from bottom, the future demons' cost is deterministic

**Solution - DFS w/ top-down**
- Logic
  - post-calculation DFS, find the min cost to reach to the current cell, either `from bottom` or `from right`
  - then extra HP needed would be `neededHp = cur - mincost`
    - if `neededHp < 0`, which means we need more `hp` to rescue the princess, `dp[i][j] = -neededHp`
      - do not add `cur`, which will be automatically added when reaching this cell
    - else, which means `hp` is sufficient, then just `dp[i][j] = 1`
      - remember, we still need `1` hp to reach to the starting cell

**Solution - DP**
  - dp array with `i, j` starting from `bottom-right` cell and loop all the way up