### Thinking
**Solution - dfs + preSum**
###### Note
> In my 1st attempt, I use nested list `List<List<Integer>>` to keep the `preSum` of each path from root to each left node;  
> This fails as the eligible common part of 2 paths will be counted twice
> So, looking up each node just once => DFS 

- Logic:
  - using `prefix sum` when walking along the path
    - `HashMap` to count the occurrence of each sum
    - 2 cases:
      - case 1: if `curSum` is already equal to the `targetSum`, just add this only one combination
        - starting from the `root` (as the staring point would be `nums[-1]`)
      - case 2: if `curSum - targetSum (k)` exists, add the occurrence of this starting point `nums[p]`
        - nu.of sub-array with sum `k` up to the current `node`
      > Proof: `targetSum == 0`, if at this point `curSum != 0`, then it will check `case 2` looking for if `curSum` has already
      > appeared before;  
      > since `prefixSum` would be mono increasing array if all nums > 0, then this case cannot happen;  
      > if `prefixSum` has some nums < 0:  
      > then if `curSum` appears before at position `p`, res should `+1` => means `sum(p : curIdx) = 0`;  
      > else no sub-array (sub-path) whose sum will be 0 (no elimination effect)  
    - note: case 1 can also be done by pre-config `map` by `map.put(0, 1)`