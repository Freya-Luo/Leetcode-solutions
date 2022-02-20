### Thinking
**Solution - DFSMemo (Top down)**
- Logic:
  - A string could be divided into `s = F(prefix) + word`, where `word` is a valid one
  - Once the `postfix` in valid in the `wordDict`, recursively DFS on the `prefix` string
  - the concatenation is processed post-DFS
    - `each` valid string list from the `prefix` appends this valid `postfix`
    - `dfs(s.substring(0, i))` from the end of list to the beginning of the list
- Using memo to record the substring that has already been explored
  - **SO, `key` is the substring** `s[0: i]` and `value` is the **list of valid word strings from this substring**

**Solution - MaxLen**
- Logic:
  - pre-find the max length in the `wordDict`, so once the length of `substring` is greater than `maxLen`, there is no need to do the `substring()` operation
    - `i < cur + maxLen && i < s.length()`
    - `key` is the current starting index
  - logic is the same as the above one
    - instead, it first finds the `prefix`, once is valid, recursively DFS on teh `postfix` string
- Note
  - cannot use `temp.size()` to determine if the `prefix` is added into the res
    - WHY useful above?
      - when post concatenating, `postfix` is appended to the previous formed result, which requires `temp.size() != 0`
      - `temp.size() == 0` => can safely skip this concatenation part
    - WHY cannot use here?
      - `prefix` is prepended to the result formed by the later part of the string
      - `temp.size() == 0` from the post part of the string cannot tell the difference between `end of the string` and `invalid post part of the string`
         - invalid must skip the concatenation part
         - e.x: `"catsandog", ["cats","dog","sand","and","cat"]` would add `and` to the `res`
    