### Thinking
**Solution - UF**
- Logic: 
  - if `(0, 3) & (2, 3)` are the pairs can be swapped, then `(0, 2, 3)` any 2 of them can do the swap
  - HOW this help?
    - UF to group all the connected `indices`
    - change `indices` to `char` in `s`, assign the group root to be the groupId
    - sort `chars` in each group
    - for each index `i` in `s`
      - find which group it belongs to
      - remove the smallest char in that group