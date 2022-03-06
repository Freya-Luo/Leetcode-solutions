### Thinking
**Solution - Backtracking**
- Logic:
  - `lastStar` stores the prev `*` in `p`; `lastGuess` stores the prev matched `char's` position in `s`
  - cases:
    - case A: if `p[i] == s[j] || p[i] == '?'` => can match any, just increase both `i & j`
    - case B: if `p[i] == '*'`, greedy explore the possible matched sequence
      - store the `lastStar & lastGuess` for the late backtracking
      - here, every time we check match "k-th" chars case
        - e.g., first checks "match zero chars" situation
    - case C: if "no match", which means the prev guess is wrong
      - C.1: if `lastStar == -1`, just return false
      - C.2: if `lastStar > -1`
        - reset the `lastStar & lastGuess` pointer, re-do the searching
        - this time, **`*` matches 1 more char**
  - finally, remove all the trailing `*`

**Solution - DP**
- Logic:
  - `dp[i][j]` denotes if `s[i - 1]` matches `p[j - 1]`
  - init 1st row as `s` is `""`, `dp[0][j]` is true if `p[j - 1]` is `*`; once `p[j-1] != '*'`, all `dp[0][j`] afterwards will be false
  - cases: 
    - case A: if `p[i] != '*'`, then `dp[i][j]` can only be true if the `i` and `j`'s position matches
      - A.1: either they actually are equal
      - A.2: or `p[i]` is `?` that can match any single char
    - case B: if `p[i] == '*'`, then
      - B.1: if `dp[i - 1][j]` means we can add 1 more `*` as it can represent an empty string
      - B.2: if `dp[i][j - 1]` means we can add 1 more char for the `*`'s matched part
    