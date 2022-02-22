### Thinking
**Solution**
- Logic:
  - place books one by one, always add it to a new level
  - store the new height (`greedy`) at this position `i` in `dp[i]`
    - start looking back at <u>previous books `j` one by one</u>
    - check that while `width` is good, no.of `j` that can be moved down to this new level
      - check if bringing `j` down reduced the overall height
      - if yes, update the new lowest height
    - return the `dp[n]`