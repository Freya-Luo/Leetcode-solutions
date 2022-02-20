### Thinking
**Solution - DFSMemo (Top down)**
- Logic:
  - A string could be divided into `s = F(prefix) + word`, where `word` is a valid one
  - Once the `postfix` in valid in the `wordDict`, recursively DFS on the `prefix`
  - the concatenation is processed post-DFS
- Using memo to record the substring that has already been explored
  - **SO, `key` is the substring** `s[0: i]` and `value` is the **list of valid word strings from this substring**

**Solution - MaxLen**
- Logic:
  - pre-find the max length in the `wordDict`, so once the length of `substring` is greater than `maxLen`, there is no need to do the `substring()` operation