### Thinking
###### Note 
- when `subsring()`, `end` should `<= s.length()`

**Solutino 1 - Top-down (DFS) + Memo**
 - Key: brute force but with `checkedSubstr[]` to avoid repeating substring checking
   - for each `word`, collecting all the shorter strings into `preWords` dictionary
   - do `DFS`
     - terminating conditions:
       - `preWords` is empty
       - `start` index `==` word length => no substrs left to be checked
       - `checkedSubstr[start] != null` means `s[start: -1]` has already been checked  
         - true -- substr from `start` index is in the dict
         - false -- substr from `start` index is not in the dict
         - Why `Boolean` ?
           - make it initially be `null`, instead of `false`
     - loop process
       - from `start` all the way to the `word` end
       - LOGIC: **`preWords` contains** the current substr && then **rest** substr is **eligible `(DFS() return true)`**

**Solutino 2 - Bottom-up (DP)**
- for each `word`, do `DP`
  - LOGIC: (`dp[i]` true => `s[0: i - 1]` is in the dict) && then (`preWords` **contains** the current substr)
