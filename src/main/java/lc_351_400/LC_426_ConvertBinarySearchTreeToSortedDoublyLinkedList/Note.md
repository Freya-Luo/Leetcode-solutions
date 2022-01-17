### Thinking
###### Note
- when <u>obj</u> is **initiated with `null`**, it associates with **nothing**
  - passing it as `arg` in func call => NOT change its value
  - So, usually, keep a `global` variable


**Solution - In order traversal**
- `left-> node-> right`, so rule is link the `prev` node with the `cur` node
   - SO, need track <u>last</u> node, a.k.a the **max node** so far
     - just assign `prev = root`
     > Because of BST properties, in-order traversal returns nodes in the ascending order
   
- HOW to link?
  - case 1: `prev == null` (initially, only 1 time)
    - just init `head` node, which is the node we need to return
  - case 2: `prev != null`
    - `prev` keep the largest node until now, but `prev.val < cur.val`
    - so, `prev.right = cur` & `cur.left = prev`
  - THEN, update `prev = cur`
