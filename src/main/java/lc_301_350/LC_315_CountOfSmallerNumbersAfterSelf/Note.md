###Thinking
**Solution - MergeSort**  
`Guaranteed to be the O(NlogN) time complexity`
- Key: when merging 2 subarrays, it **already checks** the <u>smaller elements positioned to the right of the current element</u>
  - HOW? 
    - when comparing `nums[left] & nums[right]`
      - if `nums[right]` < `nums[left]`, this element satisfies the condition
        - keep a var counter `lessCnt` and increment it by `1`, which means the no.of elements smaller to the right
      - else no more right elements smaller <u>in this merge step</u>
        - add current `lessCnt` to the `res[left.originalIdx]`
    - A cumulative process, as it guarantees the ongoing 2 subarrays are already sorted themselves from the previous merging steps
  - To update the `res[i]` in **O(1)**, we have to record each element's **original index**. 
###### A. Index Array    
- `index[]` as a mapping
- instead of sorting the `numbers`, we sort its `indexes`
  - REM!! **copy back** the `sorted indexes` to the original `indexes`
> Actually, I 1st tried using `HashMap` to store the mapping relations, but the issue is we can have duplicates in the array;  
So instead, we use `index array` or the following way of constructing a new object  

###### B. Node with original index stored
- construct a new class `Node` and keep a field `oriIdx` to store the initial index
- this way, we sort the `numbers` in the array


**Solution - BITree**  
[reference](https://www.youtube.com/watch?v=WbafSgetDDk)
- Logic: using `a num's binary representation` to decrease the querying and updating time complexity
  - underline it's an abstraction, visualization is implemented by the array `nodes[]`
  - indexes in the `nodes[]` **starts from `1`/ `other non-0 index`**
    - WHY?
      - when doing `lowbit(i)`, `lowbit(0) = 0` => nothing happens
    - HOW?
      - A. calculate `offset`, shifting all nums to `1 .... n` by subtracting this `offset`
      - B. sort the `nums[]`, for each num, labeling it from `1 ...n`
- Steps:
  - starting from the `right` to `left`, get the total no.of ones smaller than the current number
    - query `nums[i] - 1`, `-1` means to find the smaller nums
  - update the current node's value and all the nodes up to the root
- downside:
  - `dummy/ empty` node in the `nodes[]` consuming space
---

### Binary Index Tree / Fenwick Tree
- Purpose: to solve the `prefix sum` problem
  - But WHY bothering?
    - if element in the `nums[]` <u>can be UPDATED</u>, then `sum(i, j)` would be O(N) again
- Key: store **partial sum in each node**, and update the total `sum` by **traversing** from <u>node to the root</u>
  - `get/query(i) & update(i)` would be both **O(logN)** `tight bound`
  - THAT IS, it spreads the result into different nodes, and collects all the values by traversing
- Logic: [visualization](https://visualgo.net/en/fenwicktree)
  - **lowbit(i): `i & (-i)`, -i = ~i + 1**
  - **common invariant**: <u>`curNode.val = sum(children.val) + nums[curNode.idx]`</u>
  - Update Tree
    - specific invariant: <i>**parentIdx = i + lowbit(i)**, i <= n</i>
    - for each `node`, **add** its value to <u>**all** the nodes on the path fromt this node to the root</u>
  - Query Tree
    - specific invariant: _**parentIdx = i - lowbit(i)**, i > 0_
    - **collect all** the nodes' value on <u>the path from this node to the root</u>
  - different tree structure, need to transform
![example](C:\Users\y233l\Desktop\developer\Leetcode\src\main\resources\refs\img.png)
