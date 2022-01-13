### Thinking
> Could be solved using PQ, and always starting with the most frequent `char`;
keep `prevChar` and `curChar` to avoid contiguous same `char`s.  
=> Time: O(NlogN) -- N: no.of differ chars

- HOW to solve it in `O(n)`?
  - same idea, start from the char with max `count`
    - if `maxCount > (len(s) + 1) / 2` => must exist 2 adj `c` are same
    - else must exist a valid string
      - insert in the order `0, 2, 4, 6,..., (len(s) - 1), 1, 3, 5, 7, ..., (len(s) - 2)`
        - insert with space separated