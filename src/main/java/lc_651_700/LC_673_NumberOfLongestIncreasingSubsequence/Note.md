### Thinking
**Solution - Brute Force**
- Logic:
  - `len[i]`: the max length of IS at `i` until now; `cnt[i]`: the count of IS with this max length 
  - for each `num i`, loop through all the previous numbers `[0,..., i -1]`
    - only useful when `nums[i] > nums[j]`
    - if `len[i] < len[j] + 1` => means `i` is explored first time
      - update `len[i] & cnt[i]`
    - else if `len[i] = len[j] + 1` => means `i` can be reached from other subsequences
      - just increase the `cnt[i]` by `cnt[j]`

**Solution - DP (LIS)**
> The logic is the same as LC.300, but there are some modifications: 1) for each `len (i)`, recording the history of all `tails` occur at `dp[i - 1]`; 2) also keep a variable to keep the accumulated sum (count) of the current IS 

- Logic:
  - the list is composed of `[{tail1, count1}, {tail2, count2}, ...]`
  - **Tricky 1**: record the history of all `tail numbers`
    - the previous step is the same as that in LC.300: find the index`(left)` of 1st number in `dp[0, i - 1]` that `>= curNum`
    - BUT, instead of just replacing it, we need to loop through the history
    - here, `left - 1` gives us the **proper list**
      - assuming that the current `num` makes the length of LIS to be `k`, then this list gives all tails of length `k-1` subsequence
      - the list is in the **decreasing order**, as we always add a smaller number to the end of the list
      - since _BS_ only check `list.size() - 1` the last element of the list, numbers in front of it could be larger than `curNum`, which are invalid options
      - SO, need to loop through this list to find the <u>cutoff number</u>
  - **Tricky 2**: `prefix sum` as the count number in the list
    - linear scan of the list and collect all the count is doable, but it can be optimized with `prefix sum`
    - using another <u>Binary Search</u>
      - when add a new entry, inserting `curOptions (smaller) + count of the last entry in the list`
      - since the numbers in the list decreases, need to find the <u>1st entry whose `tail`</u> is `>= curNum`, then using last entry `count` - this entry `count
        - `lo - 1` gives the index of this entry, before this, all entries `tail` is invalid choice
        - SO, the valid, due to <u>Prefix Sum</u>, numbers can be directly given by `last entry's count - this entry's count`
      - then, the last entry's count of `dp[len - 1] (0-indexed)` would be the total choices
