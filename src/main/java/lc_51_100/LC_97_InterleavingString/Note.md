### Thinking
**Solution**
- Logic:
  - `dp[i][j]` indicates if is possible that `the prefix of s3 with length (i+j+2)` can be formed by interleaving `s1[0:i]` and `s2[0:j]`
    - invariant: a `char` in `s3` is either from a `char` in `s1` or `s2`
  - cases:
    - case 1: neither `i-th` char in `s1` nor `j-th` char in `s2` matches the `k-th` char in `s3`
      - `k = i + j + 1`, in which interleaving of prefixes of `s1 & s2` can never result in prefix `k + 1` of s3`
      - SO, leave it as `FALSE`
    - case 2: either `i-th` char in `s1` or `j-th` char in `s2` matches the `k-th` char in `s3`
      - case 2.1: if `i-th` in `s1` matches `(i + j + 1)-th` char in `s3`
        - to keep the invariant, need to **ensure `s1[0:i-1]` and `s2[0:j]` is `TRUE`**
      - case 2.2: if `j-th` in `s2` matches `(i + j + 1)-th` char in `s3`
        - need to **ensure `s1[0:i]` and `s2[0:j-1]` is `TRUE`**
      - NOTE: these 2 cases are not mutual exclusive, and they can happen at the same time
        - when `s1[i]` and `s2[j]` are equal
        - NEED to make sure the _2nd case not overwrite the 1st case_