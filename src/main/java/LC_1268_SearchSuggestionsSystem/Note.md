### Thinking
**Solution 1 - Trie**
- Use the standard boolean to indicate `isWord`
  ###### Note
  - `insertWord()` and `getWordsWithPrefix()` along with that `dfs` procedure
    - do much of the repeating searching steps
    - though do not affect much of the time complexity => `O(M * N)`
  - O(k<sup>2</sup>) extra time from `substring()`
  - `dfs()` as we only go down 3 levels deep => O(1)
  
**Solution 2 - Trie with optimization**
- Keep a list of `suggestions` in each node
  - trade-off: increase space complexity but saving time complexity 
  - collecting strings when building the Trie
- though the dominant part of big O is still `O(M * N)`, O(k<sup>2</sup>) would go down to `O(k)`
- `Collections.sort()` would be O(1) as the list size won't exceed 3

**Solution 3 - Sort + BS**
- key idea:
  - sort the `products` lexicographically
  - BS to find the right-most string `startWith` the `prefix` (if exists)
  - collect at most 3 eligible strings